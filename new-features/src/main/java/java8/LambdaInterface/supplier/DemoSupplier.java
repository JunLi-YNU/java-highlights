package java8.LambdaInterface.supplier;

import java.util.function.Supplier;

/**
 * @program: java-highlights
 * @description: supplier接口的使用：指定生产什么数据就生产什么数据类型
 * @author: Cageling
 * @created: 2022/06/26 18:10
 */
public class DemoSupplier {
    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }
    public static int getMaxNum(Supplier<Integer> supplier){
        return supplier.get();
    }
    public static void main(String[] args) {
        //生产者接口
        System.out.println(getString(()-> "supply a String."));
        int[] ints = new int[]{100,55,101,32};
        int max = getMaxNum(()->{
            int maxNum = ints[0];
            for (int i: ints
                 ) {
                if(i > maxNum) maxNum = i;
            }
            return maxNum;
        });
        System.out.println(max);
    }
}
