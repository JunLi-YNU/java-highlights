package java8.demoInterface;

public class DemoInterface {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public String normalMethod(String str) {
                return null;
            }
        };
        myInterface.defaultMethod();
    }
}
