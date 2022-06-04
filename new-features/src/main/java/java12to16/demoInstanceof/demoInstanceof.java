package java12to16.demoInstanceof;

public class demoInstanceof {
    public static void main(String[] args) {
        User userA = new User("JunLi"), userB = new User("JunLi");
        System.out.println(userA.equals(userB));
    }
}
