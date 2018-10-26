package com.example.test.demo.bank;

/**
 *
 */
public class Bank {

    public static int money = 1000;

    public void counter(int money){
        this.money-=money;
        System.out.println("A取走了:"+money+"元钱，账户还剩余:"+this.money+"元钱");
    }

    public void ATM(int money){
        this.money-=money;
        System.out.println("B取走了:"+money+"元钱，账户还剩余:"+this.money+"元钱");
    }
}
