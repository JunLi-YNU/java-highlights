package java17.sealed;

public sealed interface SealedInterface permits MyPermitInterfaceImpl {
    String getString(String a,String b);
}

