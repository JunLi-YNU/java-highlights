package stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    private static final String DEMO_PATH = "/Users/junli/IntelliJIDEAProjects/JavaLearnDemo/demo.txt";
    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get(DEMO_PATH)),
                StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        int count = 0;
        //通过循环获取
        count = getCountOfCirculation(words, count);
        System.out.println(count);
        //通过流的方式进行数据的统计
        count = getCountOfStream(words,count);
        System.out.println(count);
        count = getCountOfParallel(words,count);
        System.out.println(count);

    }

    private static int getCountOfParallel(List<String> words, int count) {
        count = (int)words.parallelStream().filter(w -> w.length()>10 ).count();
        return count;
    }

    private static int getCountOfStream(List<String> words, int count) {
        count = (int) words.stream().filter(word -> word.length()>10).count();
        return count;
    }

    private static int getCountOfCirculation(List<String> words, int count) {
        for (String word: words
             ) {
            System.out.println(word);
            if(word.length()>10){
                count++;
            }
        }
       return count;
    }
}
