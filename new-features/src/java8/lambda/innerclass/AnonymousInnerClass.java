package java8.lambda.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args){
        startThreadOfJava8();
        //不会产生$class文件，所以Lambda不是单纯的语法糖
        startThreadOfJava8Afterward();
        Runnable runnable  = new Runnable() {
            @Override
            public void run() {
                System.out.println("一个接口的实现");
            }
        };

        Runnable lambdaRunnable = ()->{
            System.out.println("一个接口的实现");
        };
    }

    //在Java8以前开启一个线程
    public static void startThreadOfJava8(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开启一个线程使用Java8的语法");
            }
        });
        thread.start();
    }

    //在Java8以后使用lambda语法开启一个线程
    public static void startThreadOfJava8Afterward(){
        Thread thread = new Thread(()-> {
            System.out.println("开启一个线程是Java8以后的语法");
        });
        thread.start();
    }
}
