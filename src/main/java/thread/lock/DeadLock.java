package thread.lock;

import untils.SleepHelper;

/**
 * @program: java-highlights
 * @description: 死锁代码
 * @author: Cageling
 * @created: 2022/06/13 22:55
 */
public class DeadLock {
    public static void main(String[] args) {
        MySyn mySyn = new MySyn();
        Thread threadA = new Thread(() -> {
            mySyn.methodA();
        });
        Thread threadB = new Thread(() -> {
            mySyn.methodB();
        });
        threadA.start();
        threadB.start();
    }
}

class MySyn {
    private Object lockA = new Object();
    private Object lockB = new Object();

    public MySyn() {
    }

    public void methodA() {
        synchronized (lockA) {
            System.out.println("方法A开始运行");
            SleepHelper.sleep(3);
            synchronized (lockB) {
                System.out.println("方法A继续运行运行");
            }
        }
    }

    public void methodB() {
        synchronized (lockB) {
            System.out.println("方法B开始运行");
            SleepHelper.sleep(1);
            synchronized (lockA) {
                System.out.println("方法B继续运行运行");
            }
        }
    }
}