package com.tzxylao.lambda;

import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 * Created by laoliangliang on 18/9/3.
 */
public class FunctionDemo {
    public static void main(String[] args) {

        Predicate<Integer> predicate = i -> i>0;
        System.out.println(predicate.test(2));

        IntConsumer consumer = i -> System.out.println(i);
        consumer.accept(22);

        //方法引用
        IntConsumer consumer2 = System.out::println;
        consumer2.accept(33);
    }
}
