package stream;

import java.util.stream.Stream;

/**
 * @program: java-highlights
 * @description: Stream中的方法
 * @author: Cageling
 * @created: 2022/06/26 16:35
 */
public class StreamMethod {
    //延迟方法：返回数据类型仍然为stream接口自身方法，因此支持链式调用。
    //终结方法：返回值数据类型已经不是stream自身的方法，链式调用的结束。例如：firEach()和count().
    public static void main(String[] args) {
        Stream<String> streamOne = Stream.of("apple", "application", "banana", "coco");
        //forEach方法 forEach(Consumer<? super T> action)
        streamOne
                .forEach(s -> System.out.println("forEach：" + s));
        //Stream是一个管道流，只能被消费一次
        //filter方法 filter(Predicate<? super T> predicate)
        Stream<String> streamTwo = Stream.of("apple", "application", "banana", "coco");
        streamTwo
                .filter(s -> s.startsWith("app"))
                .forEach(s -> System.out.println("filter: " + s));
        //map方法 map(Function<? super T, ? extends R> mapper)
        Stream<String> streamThree = Stream.of("12", "123", "1234", "12345");
        streamThree
                .map(s -> Integer.valueOf(s))
                .forEach(s -> System.out.println("map: " + s));
        //count方法
        Stream<String> streamFour = Stream.of("apple", "application", "banana", "coco");
        long count = streamFour
                .filter(s -> s.startsWith("app"))
                .count();
        System.out.println("count: " + count);
        //limit方法
        Stream<String> streamFive = Stream.of("apple", "application", "banana", "coco");
        streamFive
                .limit(2)
                .forEach(s -> System.out.println(s));
        //skip方法
        Stream<String> streamSix = Stream.of("apple", "application", "banana", "coco");
        streamSix
                .skip(2)
                .forEach(s -> System.out.println("skip: " + s));
        //concat方法
        Stream<String> streamA = Stream.of("A");
        Stream<String> streamB = Stream.of("B");
        Stream
                .concat(streamA, streamB)
                .forEach(s -> System.out.println("concat: " + s));
        Stream
                .concat(streamA, streamB)
                .forEach(System.out::println);
    }
}
