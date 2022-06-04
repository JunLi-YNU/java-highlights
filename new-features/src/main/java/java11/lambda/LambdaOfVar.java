package java11.lambda;

import java.util.function.Consumer;

public class LambdaOfVar {
    public static void main(String[] args) {
        //在Java11之前var关键字在lambda中的使用是不支持的，Java11之后就可以使用了
        Consumer<String> stringConsumer = (var s)->{
            System.out.println(s);
        };
        stringConsumer.accept("java 11 lambda of var");
    }
}
