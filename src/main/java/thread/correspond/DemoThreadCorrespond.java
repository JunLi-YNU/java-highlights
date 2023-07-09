package thread.correspond;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @program: java-highlights
 * @description: 线程间的通信
 * @author: Cageling
 * @created: 2022/06/14 00:13
 */
public class DemoThreadCorrespond {
    public static void main(String[] args) {
        User user = new User();
        Thread input = new Thread(() -> {
            boolean flag = false;
            while (true) {
                if (flag) {
                    user.setUser("LiLi", "女");
                    flag = false;
                } else {
                    user.setUser("JunLi", "男");
                    flag = true;
                }
            }
        });
        Thread output = new Thread(() -> {
            while (true) {
                user.out();
            }
        });
        input.start();
        output.start();
    }
}
