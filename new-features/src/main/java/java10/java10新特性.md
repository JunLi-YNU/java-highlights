# Java 10 新特性

## Java 10 局部变量的类型推断
> 1.java 10 提供了 var定义变量的方式并且可以进行类型推断。<br/>
> 2.var的使用仅限于在局部中。<br/>
> 3.var对于基本数据类型是无法进行自动封装的。所以无法getClass().<br/>

```java
public class LocalTypeInference {
//    var a = 10; //不可以在成员变量中使用
    public static void main(String[] args) {
        var str = "Hello Java!"; //可以使用var 来定义变量
        System.out.println(str);
        System.out.println(str.getClass()); //可以进行类型推断class java.lang.String
        var b = 10;
//        System.out.println(b.getClass());//无法getClass()对于基本数据类型而言var是无法进行类型推断的
    }
}
```
