package io;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class MyFileWriter {
    FileWriter myFileWriter = null;

    public FileWriter setMyFileWriter(String fileStr){

        try {
            myFileWriter = new FileWriter(fileStr,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myFileWriter;
    }

    public void writeString(String writeStr){
        try {
            myFileWriter.write(writeStr);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            throw new RuntimeException("write string data failed！");
        }
    }

    public void closeSource(){
        try {
            myFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(myFileWriter!=null){
                try {
                    myFileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
