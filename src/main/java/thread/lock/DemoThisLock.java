package thread.lock;

public class DemoThisLock {
    public static void main(String[] args) {
        FunctionThisLock functionThisLock = new FunctionThisLock();
        //同步方法线程，一个类一旦存在一个同步方法就会将整个类加上同步锁，类中其他的方法在其他线程调用也要竞争他的锁
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                functionThisLock.addNumOne();
                System.out.println("NumOne:" + functionThisLock.getNumOne());
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                functionThisLock.addNumTwo();
                System.out.println("NumTwo:" + functionThisLock.getNumTwo());
            }
        });
        Thread threadThree = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                functionThisLock.addNumThree();
                System.out.println("NumThree:" + functionThisLock.getNumThree());
            }
        });
        Thread threadFour = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                functionThisLock.addNumFour();
                System.out.println("NumFour:" + functionThisLock.getNumFour());
            }
        });
        //同一个类的同步方法直接是否会争抢this锁,直觉是会产生this锁的争抢的
//        threadOne.start();
//        threadFour.start();
        //同步代码块
        threadTwo.start();
        threadThree.start();
    }
}
