package java8.LambdaInterface.predicate;

import java.util.function.Predicate;

/**
 * @program: java-highlights
 * @description: 演示Predicate的接口的使用
 * @author: Cageling
 * @created: 2022/06/26 18:37
 */
public class DemoPredicate {
    //test方法
    public static boolean checkString(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }

    //and方法 与
    public static boolean checkStringAnd(String str, Predicate<String> predicateStartWith, Predicate<String> predicateEndWith) {
        return predicateStartWith.and(predicateEndWith).test(str);
    }

    //or方法 或
    public static boolean checkStringOr(String str, Predicate<String> predicateStartWith, Predicate<String> predicateEndWith) {
        return predicateStartWith.or(predicateEndWith).test(str);
    }

    //negate方法 取反
    public static boolean checkStringNegate(String str, Predicate<String> predicateStartWith) {
        return predicateStartWith.negate().test(str);
    }

    public static void main(String[] args) {
        boolean checkStart = checkString("lijun", str -> str.startsWith("l"));
        System.out.println("test: " + checkStart);
        boolean checkStartEndAnd = checkStringAnd("lijun", name -> name.startsWith("l")
                , name -> name.endsWith("n"));
        System.out.println("and: " + checkStartEndAnd);
        boolean checkStartEndOr = checkStringOr("lijun", name -> name.startsWith("l")
                , name -> name.endsWith("l"));
        System.out.println("or: " + checkStartEndOr);
        boolean checkStartNegate = checkStringNegate("lijun", name -> name.startsWith("l"));
        System.out.println("negate: " + checkStartNegate);
    }
}
