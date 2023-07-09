module module.two {
    requires module.one;//引入整个模块
    provides com.reflection.MyInterface
            with com.reflect.MyInterfaceImpl;//指名引入模块的接口的具体实现类
}