package java8.LambdaInterface.consumer;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * @program: java-highlights
 * @description: 演示Consumer接口的使用
 * @author: Cageling
 * @created: 2022/06/26 15:55
 */
public class DemoConsumer {
    //转为大写和反转字符串
    public static void uppercaseAndReverseName(String name, Consumer<String> uppercaseCon,Consumer<String> reverseCon){
        uppercaseCon.andThen(reverseCon).accept(name);
    }
    public static void main(String[] args) {
        uppercaseAndReverseName("lijun", (name)->{
            System.out.println(name.toUpperCase());
        },(name)->{
            System.out.println(new StringBuffer(name).reverse().toString());
        });
    }
}
