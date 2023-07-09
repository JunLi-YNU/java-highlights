package untils;

/**
 * @program: java-highlights
 * @description: object对象工具类
 * @author: Cageling
 * @created: 2022/06/14 01:05
 */
public class ObjectHelper {

    public static void waiter(Object o){
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void notifier(Object o){
        o.notify();
    }

    public static void notifierAll(Object o){
        o.notifyAll();
    }
}
