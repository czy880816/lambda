package com.tzxylao.stream;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by laoliangliang on 18/9/4.
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        String str = "my name is 007";

        //使用并行流，不保证顺序
        str.chars().parallel().forEach(i -> System.out.print((char)i));
        System.out.println();
        //使用forEachOrdered，保证顺序
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
        System.out.println();
        //收集到list
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

        //使用reduce拼接字符串
        Optional<String> reduce = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);

        System.out.println(reduce.orElse(""));

        //带初始化值得reduce，等同上面
        String reduce2 = Stream.of(str.split(" ")).reduce("",(s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce2);

        //计算所有单词总长度
        Integer reduce1 = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(reduce1);

        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());

        //无限流上要加短路操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println(first.getAsInt());
    }
}
