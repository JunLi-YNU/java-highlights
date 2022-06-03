# Lambda 表达式

### Lambda表达式与匿名内部类的区别
> 1.lambda表达式不是简单的语法糖，仅仅是对匿名内部类的简写。
> 它在编译之后不会像匿名内部类 一样产生一个匿名内部类的$class文件。
> 2.lambda只能是接口，不支持抽象类。而且接口也仅能有一个抽象懊恼过方法（可以有多个方法，
> 但是必须有实现。
> 3.@FunctionalInterface此注解表示符合函数式接口定义，支持lambda表达式。
> 4.lambda支持方法引用。(String str)-> method(str);可以替换为Main::method(str);

**Lambda实现接口**
```java
Runnable runnable  = new Runnable() {
    public void run() {
        System.out.println("一个接口的实现");
    }
};

Runnable lambdaRunnable = ()->{
    System.out.println("一个接口的实现");
};
```