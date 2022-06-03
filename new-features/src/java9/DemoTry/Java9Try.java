package java9.DemoTry;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Java9Try {
    public static void main(String[] args) throws IOException {
        //java8 之前的写法
        InputStream inputStream = Files.newInputStream(Paths.get("demo.txt"));
        try {
            for (int i = 0; i < 100 ; i++) {
                System.out.print((char) inputStream.read());
            }
        }catch (Throwable throwable){
            if(inputStream != null){
                try {
                    inputStream.close();
                }catch (Throwable throwable1){
                    throwable.addSuppressed(throwable);
                }
            }
        }
        System.out.println();
        //java8的写法
        try(InputStream inputStreamJava9 = Files.newInputStream(Paths.get("demo.txt"));) {
            for (int i = 0; i < 100 ; i++) {
                System.out.print((char) inputStreamJava9.read());
            }
        }
        System.out.println();
        //java9的写法
        InputStream inputStreamJava9 = Files.newInputStream(Paths.get("demo.txt"));
        try(inputStreamJava9) {
            for (int i = 0; i < 100 ; i++) {
                System.out.print((char) inputStreamJava9.read());
            }
        }
    }
}
