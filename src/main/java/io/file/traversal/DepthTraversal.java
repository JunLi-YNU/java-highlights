package io.file.traversal;

import java.io.File;

public class DepthTraversal {
    private static int hierarchy = 0;
    private static final String MY_MODULE_PATH = "/Users/junli/IntelliJIDEAProjects/JavaLearnDemo/src/main.java.io";
    public static void main(String[] args){
        //深度优先遍历文件目录
        depthFirstTraversalFile(MY_MODULE_PATH,hierarchy);
    }

    private static void depthFirstTraversalFile(String dirPath,int hierarchy) {
        File file = new File(dirPath);
        System.out.println(getSpace(hierarchy)+file.getPath());
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                depthFirstTraversalFile(files[i].getPath(),hierarchy+1);
            }else {
                System.out.println(getSpace(hierarchy+1)+files[i].getPath()+"文件");
            }
        }
    }

    private static String getSpace(int hierarchy) {
        String space = "";
        for (int i = 0; i < hierarchy; i++) {
            space = space+ "    ";
        }
        return space;
    }
}
