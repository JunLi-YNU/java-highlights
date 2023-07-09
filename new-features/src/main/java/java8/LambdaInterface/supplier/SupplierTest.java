package java8.LambdaInterface.supplier;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args){

        Work i = getComponent(new Supplier<Work>() {
            @Override
            public Work get() {
                return null;
            }
        },5);
        System.out.println("name:"+i.getName()+" age:"+i.getAge());
    }

    private static <T> T getComponent(Supplier<T> supplier,int retryTimes){
        int mRetryTimes = retryTimes;
        T component = null;
        while ( component == null && mRetryTimes-- != 0) {
            try {
                Thread.sleep(1500);
                component = supplier.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
            System.out.println("进行了一次重试");
        }
        return component;
    }
}
