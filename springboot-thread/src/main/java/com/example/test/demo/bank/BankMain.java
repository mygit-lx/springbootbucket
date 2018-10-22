package com.example.test.demo.bank;

/**
 *
 */
public class BankMain {

    public static void main(String[] args) {
        Bank bank = new Bank();
        new PersonA(bank).start();
        new PersonB(bank).start();
    }
}
