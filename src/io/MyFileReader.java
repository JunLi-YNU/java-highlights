package io;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    FileReader fileReader = null;

    public FileReader setMyReadFile(String myFileString){
        try {
            fileReader =  new FileReader(myFileString);
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileReader;
    }

    public String readFileToString(FileReader fileReader){
        String bufStr = null;
        char[] chars = new char[1024*1024];
        int index = 0;
        try{
            while((index = fileReader.read(chars))!=-1){
                bufStr = new String(chars,0,index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufStr;
    }
    public void closeSource(){
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            throw new RuntimeException("source closed fail！");
        }
    }
}
