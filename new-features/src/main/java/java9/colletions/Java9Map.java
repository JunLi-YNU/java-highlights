package java9.colletions;

import java.util.*;

public class Java9Map {
    public static void main(String[] args) {
        //通过of方法创建的集合是不可变的
        Map<String,Integer> map = Map.of("java",17,"kotlin",2);
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        List.of();
        Set.of();
    }
}
