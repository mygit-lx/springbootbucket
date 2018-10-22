package com.example.test.demo.bank;


public class PersonA extends Thread{

    public Bank bank;

    public PersonA(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        while (bank.money>=100){
            bank.counter(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
