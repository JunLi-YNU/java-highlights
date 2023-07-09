package untils;

public class SleepHelper {

    public static void sleep(int sleepSecond) {
        try {
            Thread.sleep(sleepSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
