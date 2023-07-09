package java8.LambdaInterface.function;

import java.util.function.Function;

/**
 * @program: java-highlights
 * @description: 演示funcation接口的使用
 * @author: Cageling
 * @created: 2022/06/26 18:57
 */
public class DemoFunction {
    //将字符串转化为Integer类型
    public static Integer stringConvertInteger(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static Integer stringConvertIntegerAndThen(String str, Function<String, Integer> function,
                                                      Function<Integer, Integer> integerIntegerFunction) {
        return function.andThen(integerIntegerFunction).apply(str);
    }

    public static void main(String[] args) {
        Integer integer = stringConvertInteger("1234", str -> Integer.valueOf(str).intValue());
        System.out.println("stringConvertInteger: " + integer);
        Integer integer1 = stringConvertIntegerAndThen("1234", str -> Integer.parseInt(str),
                i -> i + 10);
        System.out.println("stringConvertIntegerAndThe: " + integer);
    }
}
