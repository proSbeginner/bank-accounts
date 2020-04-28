package com.pros;

import com.pros.model.Account;
import com.pros.model.CheckingAccount;
import com.pros.model.SavingsAccount;

public class TestAccount {
    public static void main(String[] args) {
        System.out.println("Hello");
        Account a1 = new Account(500);
        System.out.println("a1 balance = " + a1.getBalance());

        Account a2 = new Account(1500);
        System.out.println("a2 balance = " + a2.getBalance());

        Account a3 = new SavingsAccount(800);
        System.out.println("a3 balance = " + a3.getBalance());

        SavingsAccount a4 = new SavingsAccount(800);
        System.out.println("a3 balance = " + a4.getBalance());

        Account a5 = new CheckingAccount(1000);
        System.out.println("a5 balance = " + a5.getBalance());
    }
}
