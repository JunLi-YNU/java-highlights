package runtime;

import java.io.IOException;

public class MyRuntime {
    public static void main(String[] args){
        runtimeTV();
    }
    public static void runtimeTV(){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("qq.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
