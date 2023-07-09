package thread;

import java.util.concurrent.Executors;

public class DemoThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()),"真的开启了线程");
        thread.start();
        thread.wait();
        synchronized (new Object()){}
        System.out.println(thread.getName()+Thread.currentThread().getName());
//        Executors.newFixedThreadPool();
    }
}
