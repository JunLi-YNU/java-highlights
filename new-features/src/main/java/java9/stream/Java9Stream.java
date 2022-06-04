package java9.stream;

import java.util.stream.Stream;

public class Java9Stream {
    public static void main(String[] args) {
        Stream
                .of(1, 2, 1, 3, 2, 4, 5)
                .distinct() //去重操作
                .filter(i -> i < 3)//过滤
                .forEach(System.out::println);

        //新增方法
        Stream
                .ofNullable(null)//新增方法
                .forEach(System.out::println);
        //迭代产生数据
        Stream
//                .iterate(0, i -> i + 1) //java8
//                .limit(10)
                .iterate(0, i -> i < 20,i -> i + 1) //java9 将limit循环限制改进到iterate中
                .takeWhile(i -> i < 10) //截断数据流的产生
                .forEach(System.out::println);
        Stream
                .iterate(0, i -> i < 20,i -> i + 1) //java9 将limit循环限制改进到iterate中
                .dropWhile(i -> i < 15) //丢弃产生的数据流
                .forEach(System.out::println);
    }
}
