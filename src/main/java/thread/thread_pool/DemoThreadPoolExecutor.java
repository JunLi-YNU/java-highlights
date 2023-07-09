package thread.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: java-highlights
 * @description: 创建Java的线程池
 * @author: Cageling
 * @created: 2022/06/20 18:36
 */
public class DemoThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor;
//        threadPoolExecutor = new ThreadPoolExecutor(10, 20, 5, TimeUnit.HOURS, new ArrayBlockingQueue<String>(), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//
//            }
//        });
    }
}
