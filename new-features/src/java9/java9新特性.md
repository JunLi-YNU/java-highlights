# Java 9 的新特性

## Java9 模块的管理
### 模块的分类
> **系统模块:** 来自JDK和JRE的模块(官方提供的模块)，
> 可以使用java --list-modules在JShell中列出。<br/>
> **应用程序模块:** 开发人与阿安自己的模块项目。<br/>
> **自动模块:** 没有做模块包引用限制的模块(Java9以前
> 项目),提高兼容性而继续存在的模块。<br/>
> **未做包限制模块:** 在模块中未定义module-info.java
> 文件的模块。这相当于java以前的项目，<u>这样的模块在Java9
> 之后就不能提供给定义module-info.java的项目使用，只能
> 提供给未定义module-info.java的项目使用。</u><br/>

#### module-info使用

##### module-info.java:
> Java9新增的配置文件，用于模块的管理。
```java
module modulle.one { //也可以使用open关键字暴露我们整个模块
    requires transitive java.logging;//引入指定的包,并设定传递性
    exports com.reflection to module.two;//暴露相应包并指定暴露对象
    opens com.reflection;//开发指定的包，这样才可以实现反射
    uses MyInterface;//接口的暴露，用于列入当前框架的实现需要的具体引入框架方去具体实现
}
module module.two {
    requires module.one;//引入整个模块
    provides com.reflection.MyInterface
    with com.reflect.MyInterfaceImpl;//指名引入模块的接口的具体实现类
}
```
##### Interface的跨包实现
> Interface可以跨包实现的前提是<br/>
> uses MyInterface;//接口的暴露，用于列入当前框架的实现需要的具体引入框架方去具体实现<br/>
> provides com.reflection.MyInterface<br/>
with com.reflect.MyInterfaceImpl;//指名引入模块的接口的具体实现类<br/>
```java
package com.reflection;

public interface MyInterface {
    String getMyName(String firstName,String lastName);
}

import com.reflection.MyInterface;

public class MyInterfaceImpl implements MyInterface {

    @Override
    public String getMyName(String firstName, String lastName) {
        return firstName+lastName;
    }
}
```

##### 反射机制的限制
> 反射API的Java9封装和安全性得到了改进如果没有明确的授权给其他<br/>
> 模块，那么其他模块是不允许使用反射进行修改的。<br/>
> opens com.reflection;//开发指定的包，这样才可以实现反射<br/>
>  requires module.one;//引入整个模块<br/>

***在新的模块中可以这样实现的前提的是 opens com.reflection;开放了User类的权限***
```java
        User user = new User("JunLi",26);
        System.out.println(user);
        Class<User> userClass = User.class;
        Field field = userClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(user));
```
## Java9 JShell
### java --list-modules 列出当前Java所有模块
> java.base@11.0.12<br/>
java.compiler@11.0.12<br/>
java.datatransfer@11.0.12<br/>
java.desktop@11.0.12<br/>
java.instrument@11.0.12<br/>
java.logging@11.0.12<br/>
java.management@11.0.12<br/>
java.management.rmi@11.0.12<br/>
java.naming@11.0.12<br/>
java.net.http@11.0.12<br/>
java.prefs@11.0.12<br/>
java.rmi@11.0.12<br/>
java.scripting@11.0.12<br/>
java.se@11.0.12<br/>
java.security.jgss@11.0.12<br/>
java.security.sasl@11.0.12<br/>
java.smartcardio@11.0.12<br/>
java.sql@11.0.12<br/>
java.sql.rowset@11.0.12<br/>
java.transaction.xa@11.0.12<br/>
java.xml@11.0.12<br/>
java.xml.crypto@11.0.12<br/>
jdk.accessibility@11.0.12<br/>
jdk.aot@11.0.12<br/>
jdk.attach@11.0.12<br/>
jdk.charsets@11.0.12<br/>
jdk.compiler@11.0.12<br/>
jdk.crypto.cryptoki@11.0.12<br/>
jdk.crypto.ec@11.0.12<br/>
jdk.dynalink@11.0.12<br/>
jdk.editpad@11.0.12<br/>
jdk.hotspot.agent@11.0.12<br/>
jdk.httpserver@11.0.12<br/>
jdk.internal.ed@11.0.12<br/>
jdk.internal.jvmstat@11.0.12<br/>
jdk.internal.le@11.0.12<br/>
jdk.internal.opt@11.0.12<br/>
jdk.internal.vm.ci@11.0.12<br/>
jdk.internal.vm.compiler@11.0.12<br/>
jdk.internal.vm.compiler.management@11.0.12<br/>
jdk.jartool@11.0.12<br/>
jdk.javadoc@11.0.12<br/>
jdk.jcmd@11.0.12<br/>
jdk.jconsole@11.0.12<br/>
jdk.jdeps@11.0.12<br/>
jdk.jdi@11.0.12<br/>
jdk.jdwp.agent@11.0.12<br/>
jdk.jfr@11.0.12<br/>
jdk.jlink@11.0.12<br/>
jdk.jshell@11.0.12<br/>
jdk.jsobject@11.0.12<br/>
jdk.jstatd@11.0.12<br/>
jdk.localedata@11.0.12<br/>
jdk.management@11.0.12<br/>
jdk.management.agent@11.0.12<br/>
jdk.management.jfr@11.0.12<br/>
jdk.naming.dns@11.0.12<br/>
jdk.naming.ldap@11.0.12<br/>
jdk.naming.rmi@11.0.12<br/>
jdk.net@11.0.12<br/>
jdk.pack@11.0.12<br/>
jdk.rmic@11.0.12<br/>
jdk.scripting.nashorn@11.0.12<br/>
jdk.scripting.nashorn.shell@11.0.12<br/>
jdk.sctp@11.0.12<br/>
jdk.security.auth@11.0.12<br/>
jdk.security.jgss@11.0.12<br/>
jdk.unsupported@11.0.12<br/>
jdk.unsupported.desktop@11.0.12<br/>
jdk.xml.dom@11.0.12<br/>
jdk.zipfs@11.0.12<br/>

### JShell 命令
> |  键入 Java 语言表达式, 语句或声明。<br/>
|  或者键入以下命令之一:<br/>
|  /list [<名称或 id>|-all|-start]<br/>
|       列出您键入的源<br/>
|  /edit <名称或 id><br/>
|       编辑源条目
|  /drop <名称或 id><br/>
|       删除源条目
|  /save [-all|-history|-start] <文件><br/>
|       将片段源保存到文件<br/>
|  /open <file><br/>
|       打开文件作为源输入<br/>
|  /vars [<名称或 id>|-all|-start]<br/>
|       列出已声明变量及其值<br/>
|  /methods [<名称或 id>|-all|-start]<br/>
|       列出已声明方法及其签名<br/>
|  /types [<名称或 id>|-all|-start]<br/>
|       列出类型声明<br/>
|  /imports<br/>
|       列出导入的项<br/>
|  /exit [<integer-expression-snippet>]<br/>
|       退出 jshell 工具<br/>
|  /env [-class-path <路径>] [-module-path <路径>] [-add-modules <模块>] ...<br/>
|       查看或更改评估上下文<br/>
|  /reset [-class-path <路径>] [-module-path <路径>] [-add-modules <模块>]...<br/>
|       重置 jshell 工具<br/>
|  /reload [-restore] [-quiet] [-class-path <路径>] [-module-path <路径>]...<br/>
|       重置和重放相关历史记录 -- 当前历史记录或上一个历史记录 (-restore)<br/>
|  /history [-all]<br/>
|       您键入的内容的历史记录<br/>
|  /help [<command>|<subject>]<br/>
|       获取有关使用 jshell 工具的信息<br/>
|  /set editor|start|feedback|mode|prompt|truncation|format ...<br/>
|       设置配置信息<br/>
|  /? [<command>|<subject>]<br/>
|       获取有关使用 jshell 工具的信息<br/>
|  /!<br/>
|       重新运行上一个片段 -- 请参阅 /help rerun<br/>
|  /<id><br/>
|       按 ID 或 ID 范围重新运行片段 -- 参见 /help rerun<br/>
|  /-<n><br/>
|       重新运行以前的第 n 个片段 -- 请参阅 /help rerun<br/>
|  
|  有关详细信息, 请键入 '/help', 后跟<br/>
|  命令或主题的名称。<br/>
|  例如 '/help /list' 或 '/help intro'。主题:<br/>
|  <br/>
|  intro<br/>
|       jshell 工具的简介<br/>
|  keys<br/>
|       类似 readline 的输入编辑的说明<br/>
|  id<br/>
|       片段 ID 以及如何使用它们的说明<br/>
|  shortcuts<br/>
|       片段和命令输入提示, 信息访问以及<br/>
|       自动代码生成的按键说明<br/>
|  context<br/>
|       /env /reload 和 /reset 的评估上下文选项的说明<br/>
|  rerun<br/>
|       重新评估以前输入片段的方法的说明<br/>

## Java9 Interface接口中也支持private
```java
public interface MyInterface {
    //默认方法
    default String defaultMethod(){
       return "接口的默认方法的实现";
    };
    //私有方法
    private static String privateMethod(){
        return "接口的私有方法";
    };
    //静态方法
    static String staticMethod(){
        System.out.println("调用了接口的私有方法");
        return privateMethod();
    };
    //普通方法
    String normalMethod(String str);
}
```
## Java9 集合框架支持of创建不可变集合
```java
        //通过of方法创建的集合是不可变的
        Map<String,Integer> map = Map.of("java",17,"kotlin",2);
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        List.of();
        Set.of();
```
## Java9 改进Stream API
> 1.新增ofNullable()方法<br/>
> 2.数据流生产限制limit方法可以直接写到iterate()方法中<br/>
> 3.新增数据截断方法takeWhile()<br/>
> 4.新增数据丢弃方法dropWhile()<br/>
```java
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
```
## Java9 try-with-resource语句 
> 1.java8 可以将try的对象定义语句直接塞入try(try(InputStream inputStreamJava8 = Files.newInputStream(Paths.get("demo.txt"));))<br/>
> 2.java9 可以将变量塞入到try()中<br/>
> 3.都省略了对异常的捕获<br/>
```java
        //java8 之前的写法
        InputStream inputStream = Files.newInputStream(Paths.get("demo.txt"));
                try {
                for (int i = 0; i < 100 ; i++) {
        System.out.print((char) inputStream.read());
        }
        }catch (Throwable throwable){
        if(inputStream != null){
        try {
        inputStream.close();
        }catch (Throwable throwable1){
        throwable.addSuppressed(throwable);
        }
        }
        }
        System.out.println();
        //java8的写法
        try(InputStream inputStreamJava9 = Files.newInputStream(Paths.get("demo.txt"));) {
        for (int i = 0; i < 100 ; i++) {
        System.out.print((char) inputStreamJava9.read());
        }
        }
        System.out.println();
        //java9的写法
        InputStream inputStreamJava9 = Files.newInputStream(Paths.get("demo.txt"));
        try(inputStreamJava9) {
        for (int i = 0; i < 100 ; i++) {
        System.out.print((char) inputStreamJava9.read());
        }
        }
```

## java9 Optional 新增方法
> 1. 新增ifPresentOrElse()方法，如果被包装元素是null，可进行Else操作。<br/>
> 2. 新增or()方法被包装元素如果为null，则可重新指定元素。
```java
        String str = null;
        //新增ifPresentOrElse方法
        Optional
                .ofNullable(null)
                .ifPresentOrElse(s -> System.out.println("被包装的元素是:"+s),
                        () -> System.out.println("被包装的元素是null"));
                
        //新增or()方法
        Optional
                .ofNullable(null)
                .or(()-> Optional.of("如果元素为null,可以重新指定一个元素"))
                .ifPresent(System.out::println);
```