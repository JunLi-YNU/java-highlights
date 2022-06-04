package java12to16.nullpointer;

public class ImproveNullPoint {
    public static void main(String[] args) {
        System.out.println(add(10,null));//Cannot invoke "java.lang.Integer.intValue()" because "b" is null
    }

    private static int add(Integer a, Integer b) {
        return a + b;
    }
}
