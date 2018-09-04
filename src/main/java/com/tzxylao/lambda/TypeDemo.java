package com.tzxylao.lambda;

/**
 * Created by laoliangliang on 18/9/3.
 */
public class TypeDemo {

    public static void main(String[] args) {
        IMath lambda = (x,y)-> x+y;

        //数组里
        IMath[] lambdas = {(x,y) -> x+y};

        //强转
        Object lambda2 = (IMath)(x,y) -> x+y;

        TypeDemo demo = new TypeDemo();
        demo.test((IMath)(x,y)->x+y);
    }

    public void test(IMath math) {

    }
}

interface IMath {
    int add(int x, int y);
}
