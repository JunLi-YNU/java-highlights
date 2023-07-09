package thread.lock;

import untils.SleepHelper;

public class FunctionThisLock {
    private int numOne = 100;
    private int numTwo = 100;
    private int numThree = 100;
    private int numFour = 100;
    private static int numFive = 100;
    Object lockTwo = new Object();
    Object lockThree = new Object();

    FunctionThisLock(){

    }

    public int getNumOne() {
        return numOne;
    }

    public void setNumOne(int numOne) {
        this.numOne = numOne;
    }

    public int getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(int numTwo) {
        this.numTwo = numTwo;
    }

    public int getNumThree() {
        return numThree;
    }

    public void setNumThree(int numThree) {
        this.numThree = numThree;
    }

    public int getNumFour() {
        return numFour;
    }

    public void setNumFour(int numFour) {
        this.numFour = numFour;
    }

    /*
     * @Description: 同步方法
            * @param null
            * @return: 
            *
     * @Creator: junli
            * @Date: 2022/6/13 22:29
     *
     * @Modify: junli
            * @Date: 2022/6/13 22:29
     *
     */
    public synchronized void addNumOne(){
        SleepHelper.sleep(1);
        numOne += 100;
    }
    
    /*
     * @Description: 没有睡眠的同步代码块
            * @param null
            * @return: 
            *
     * @Creator: junli
            * @Date: 2022/6/13 22:30
     *
     * @Modify: junli
            * @Date: 2022/6/13 22:30
     *
     */
    public  void addNumTwo(){
        synchronized (lockTwo){
            numTwo += 100;
        }
    }
    /*
     * @Description: 请在此处输入方法描述信息
            * @param null
            * @return: 
            *
     * @Creator: junli
            * @Date: 2022/6/13 22:31
     *
     * @Modify: junli
            * @Date: 2022/6/13 22:31
     *
     */
    public void addNumThree(){
        synchronized (lockThree){
            SleepHelper.sleep(3);
            numThree += 100;
        }
    }
    
    /*
     * @Description: 没有睡眠的同步方法
            * @param 
            * @return: void
            *
     * @Creator: junli
            * @Date: 2022/6/13 22:38
     *
     * @Modify: junli
            * @Date: 2022/6/13 22:38
     *
     */
    public synchronized void addNumFour() {
        numFour += 100;
    }
    /*
     * @Description: 静态同步方法
            * @param
            * @return: void
            *
     * @Creator: junli
            * @Date: 2022/6/13 22:49
     *
     * @Modify: junli
            * @Date: 2022/6/13 22:49
     *
     */
    public static void addNumFive(){
        numFive += 100;
    }
}
