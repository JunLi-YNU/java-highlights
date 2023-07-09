package stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * @program: java-highlights
 * @description: 集合转换为Stream流
 * @author: Cageling
 * @created: 2022/06/26 16:20
 */
public class CollectionConvertStream<E> {

    /*
     * @Description: 将数组转化为Stream流
            * @param array
            * @return: java.util.stream.Stream
            *
     * @Creator: junli
            * @Date: 2022/6/26 16:29
     *
     * @Modify: junli
            * @Date: 2022/6/26 16:29
     *
     */
    public Stream ArrayConvertStream(Array array){
        return Stream.of(array);
    }

    /*
     * @Description: 将list集合转换为stream
            * @param list
            * @return: java.util.stream.Stream
            *
     * @Creator: junli
            * @Date: 2022/6/26 16:25
     *
     * @Modify: junli
            * @Date: 2022/6/26 16:25
     *
     */
    public Stream ListCovertStream(List<E> list){
        return list.stream();
    }

    /*
     * @Description: 将set集合转换为stream流
            * @param set
            * @return: java.util.stream.Stream
            *
     * @Creator: junli
            * @Date: 2022/6/26 16:27
     *
     * @Modify: junli
            * @Date: 2022/6/26 16:27
     *
     */
    public Stream SetConvertStream(Set<E> set){
        return set.stream();
    }

    /*
     * @Description: 将map转化为Stream流
            * @param map
            * @return: java.util.stream.Stream
            *
     * @Creator: junli
            * @Date: 2022/6/26 16:31
     *
     * @Modify: junli
            * @Date: 2022/6/26 16:31
     *
     */
    public Stream MapConvertStream(HashMap<E,E> map){
        return map.entrySet().stream();
    }
    public Stream MapKeyConvertStream(Hashtable<E,E> hashtable){
        return hashtable.keySet().stream();
    }
    public Stream MapValueConvertStream(LinkedHashMap<E,E> linkedHashMap){
        return linkedHashMap.values().stream();
    }
}
