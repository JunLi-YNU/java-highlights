package java9.optional;

import java.util.Optional;

public class Java9Optional {
    public static void main(String[] args) {
        String str = null;
        //新增ifPresentOrElse方法
        Optional
                .ofNullable(null)
                .ifPresentOrElse(s -> System.out.println("被包装的元素是:"+s),
                        () -> System.out.println("被包装的元素是null"));

        //新增or()方法
        Optional
                .ofNullable(null)
                .or(()-> Optional.of("如果元素为null,可以重新指定一个元素"))
                .ifPresent(System.out::println);
    }
}
