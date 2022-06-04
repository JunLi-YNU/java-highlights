package java17.sealed;

public final class MyPermitInterfaceImpl implements SealedInterface {
    @Override
    public String getString(String a, String b) {
        return a + b;
    }
}
