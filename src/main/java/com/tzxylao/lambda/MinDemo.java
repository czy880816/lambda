package com.tzxylao.lambda;


import java.util.stream.IntStream;

/**
 * Created by laoliangliang on 18/9/3.
 */
public class MinDemo {

    public static void main(String[] args) {
        int[] nums = {22,13,44,-21,90,-333};
        int min2 = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(min2);
    }
}
