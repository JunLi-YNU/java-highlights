package java8.demoInterface;

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
