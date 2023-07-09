package main.java.io;

import java.io.IOException;
import java.io.InputStream;

public class MySystemIn {

    public static void main(String[] args){
        InputStream inputStream = System.in;

        try {
            int ch = 0;
            while ((ch=inputStream.read())!=-1){
                System.out.println((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
