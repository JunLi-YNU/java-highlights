package java17.sealed;

public class DemoSealed {
    public static void main(String[] args) {
        Class<MySealed> mySealedClass = MySealed.class;
        System.out.println(mySealedClass.isSealed());//ture
    }
}
