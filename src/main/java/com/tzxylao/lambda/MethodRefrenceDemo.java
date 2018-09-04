package com.tzxylao.lambda;

import java.util.function.*;

/**
 * Created by laoliangliang on 18/9/3.
 */

class Dog {
    private String name = "哮天犬";

    public Dog(){

    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    private int food = 10;

    public int eat(int num) {
        System.out.println("吃了" + num + "斤");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class MethodRefrenceDemo {
    public static void main(String[] args) {

        //静态方法引用
        Consumer<Dog> consumer = Dog::bark;
        Dog dog = new Dog();
        consumer.accept(dog);

        //非静态方法，使用对象实例的方法引用
//        Function<Integer, Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");

        //类名来方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤 ");

        //构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建新对象" + supplier.get());

        //带参数的构造函数的方法引用
        Function<String,Dog> function2 = Dog::new;
        System.out.println("创建新对象" + function2.apply("旺财"));
    }
}
