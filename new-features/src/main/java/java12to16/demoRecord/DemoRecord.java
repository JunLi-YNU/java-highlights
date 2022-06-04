package java12to16.demoRecord;

public class DemoRecord {
    public static void main(String[] args) {
        Account account = new Account("LiJun","123456");
        System.out.println(account.name());//LiJun
        System.out.println(account);//Account[name=LiJun, password=123456]
    }
}
