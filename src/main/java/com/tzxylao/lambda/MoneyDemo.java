package com.tzxylao.lambda;

import java.text.DecimalFormat;

/**
 * Created by laoliangliang on 18/9/3.
 */

interface IMoneyFormat{
    String format(int i);
}

class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(IMoneyFormat format){
        System.out.println("我的存款："+format.format(this.money));
    }
}

public class MoneyDemo {
    public static void main(String[] args) {
        MyMoney me = new MyMoney(9999999);
        me.printMoney(i -> new DecimalFormat("#,###").format(i));
    }
}
