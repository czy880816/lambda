package com.tzxylao.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * Created by laoliangliang on 18/9/3.
 */
interface IMoneyFormat2 {
    String format(int i);
}

class MyMoney2 {
    private final int money;

    public MyMoney2(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> format) {
        System.out.println("我的存款：" + format.apply(this.money));
    }
}

public class MoneyDemo2 {
    public static void main(String[] args) {
        MyMoney2 me = new MyMoney2(9999999);
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        me.printMoney(moneyFormat.andThen(s -> "人民币" + s));
    }
}