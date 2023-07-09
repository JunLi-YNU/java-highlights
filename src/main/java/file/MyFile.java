package file;

import java.io.File;
import java.io.FilenameFilter;

public class MyFile {
    private final static String  MY_PROJECT_DIR = "/Users/junli/AndroidStudioProjects/LiJun_work/GroovyDemo";
    public static void main(String[] args){
//        getSystemRoot();getFileDir("/");
//        getFileDir(MY_PROJECT_DIR);
//        showFilter();
        getNoHiddenFileList();
    }

    private static void getNoHiddenFileList() {

        File file = new File(MY_PROJECT_DIR);
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return ! dir.isHidden();
            }
        });
        for (File fileStr: files
             ) {
            System.out.println(fileStr.getName());
        }


    }

    private static void showFilter() {
        File file = new File("/Users/junli/AndroidStudioProjects/LiJun_work/GroovyDemo");
        String[] names = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".md");
            }
        });
        for (String name: names
             ) {
            System.out.println(name);
        }
    }

    private static void getSystemRoot() {
        File[] files = File.listRoots();
        for (File file: files
             ) {
            System.out.println("系统根目录："+file);
        }
    }

    private static void getFileDir(String dirName) {
        File file = new File(dirName);
        System.out.println(file.getFreeSpace());
        String[] fileNames = file.list();
        for (String str: fileNames
             ) {
            System.out.println(str);
        }
    }
}
