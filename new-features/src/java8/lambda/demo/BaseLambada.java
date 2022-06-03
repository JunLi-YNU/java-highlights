package java8.lambda.demo;

import java.util.Arrays;
import java.util.Comparator;

public class BaseLambada {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{3,1,4,6,8,9};
        //Java8以前的实现
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(Arrays.toString(integers));
        //Java8以后的实现
        Arrays.sort(integers,(o1,o2)-> {
            return o2.compareTo(o1);
        });
        System.out.println(Arrays.toString(integers));
        //Java以后直接引用的实现
        Arrays.sort(integers,Integer::compareTo);
        System.out.println(Arrays.toString(integers));
    }
}
