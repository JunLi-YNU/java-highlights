import com.reflection.MyInterface;

module module.one { //也可以使用open关键字暴露我们整个模块
    requires transitive java.logging;//引入指定的包,并设定传递性
    exports com.reflection to module.two;//暴露相应包并指定暴露对象
    opens com.reflection;//开发指定的包，这样才可以实现反射
    uses MyInterface;//接口的暴露，用于列入当前框架的实现需要的具体引入框架方去具体实现
}