# Java 17 新特性

## Java 17 密封类的出现
***Java 17 之前一个类想要它不被继承那么使用final修饰，一但修饰就永久不被继承。
这是存在问题的，如果我们自己要继承它也没有办法了。所以密封类就产生了。<br/>***
> 1.密封修饰符可以修饰class，abstract，interface。<br/>
> 2.一旦被密封sealed修饰，就必须指定permits。<br/>
> 3.密封类的子类必须修饰<br/>
> final:不再可以被继承<br/>
> non-sealed:不再密封<br/>
> sealed:继续向下密封<br/>
> 4.Class类中也支持密封类的判断。
```java
//密封类
public sealed class MySealed permits MyPermit {
    //密封修饰符可以修饰接口interface，类class，抽象abstract
}
//密封类的子类
public non-sealed class MyPermit extends MySealed {
    //类的子类必须使用修饰
    //1.final 不再可以被继承
    //2.non-sealed 不再密封
    //3.sealed 继续向下密封
}
//密封接口
public sealed interface SealedInterface permits MyPermitInterfaceImpl {
    String getString(String a,String b);
}
//密封接口的实现
public sealed interface SealedInterface permits MyPermitInterfaceImpl {
    String getString(String a,String b);
}
//密封类的判断
    Class<MySealed> mySealedClass = MySealed.class;
    System.out.println(mySealedClass.isSealed());//ture
```