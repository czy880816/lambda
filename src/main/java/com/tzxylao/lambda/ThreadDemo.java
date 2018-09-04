package com.tzxylao.lambda;

/**
 * Created by laoliangliang on 18/9/3.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        }).start();

        //jdk8
        new Thread(() -> System.out.println("ok")).start();
    }
}
