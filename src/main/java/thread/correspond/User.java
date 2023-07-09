package thread.correspond;

import untils.ObjectHelper;

/**
 * @program: java-highlights
 * @description: 多线程操作的数据资源
 * @author: Cageling
 * @created: 2022/06/14 01:00
 */
public class User {
    private String name;
    private String sex;
    private boolean FLAG = false;

    public synchronized void setUser(String name, String sex) {
        if (FLAG) ObjectHelper.waiter(this);
        this.name = name;
        this.sex = sex;
        FLAG = true;
        ObjectHelper.notifier(this);
    }

    public synchronized void out() {
        if (!FLAG) ObjectHelper.waiter(this);
        System.out.println("<" + name + "," + sex + ">");
        ObjectHelper.notifier(this);
        FLAG = false;
    }
}
