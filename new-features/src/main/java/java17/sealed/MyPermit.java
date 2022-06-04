package java17.sealed;

public non-sealed class MyPermit extends MySealed {
    //类的子类必须使用修饰
    //1.final 不再可以被继承
    //2.non-sealed 不再密封
    //3.sealed 继续向下密封
}
