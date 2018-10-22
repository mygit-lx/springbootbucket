package com.example.test.demo.bank;

/**
 *
 */
public class PersonB extends Thread{

    public Bank bank;

    public PersonB(Bank bank){
        this.bank=bank;
    }

    @Override
    public void run() {
        while (bank.money>=200){
            bank.ATM(200);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
