package com.pros;

import com.pros.dao.AccountDao;
import com.pros.model.Account;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AccountDao dao = new AccountDao();


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Menu =====");
            System.out.println("1. Create an account");
            System.out.println("2. Delete an account");
            System.out.println("3. Show all accounts");
            System.out.print("Please choose: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("Enter account name: ");
                    String accountName = sc.nextLine();
                    System.out.print("Enter account phone: ");
                    String accountPhone = sc.nextLine();

                    Account account = new Account();
                    account.setNumber(accountNumber);
                    account.setName(accountName);
                    account.setPhone(accountPhone);

                    int recordCount = dao.create(account);
                    if (recordCount > 0) {
                        System.out.println("An account is created");
                    }
                    break;
                }
                case 2: {
                    List<Account> list = dao.findAll();
                    for (int i = 0; i < list.size(); i++) {
                        Long accountId = list.get(i).getId();
                        String accountNumber = list.get(i).getNumber();
                        String accountName = list.get(i).getName();
                        String accountPhone = list.get(i).getPhone();

                        String line = String.format("%-5s%-15s%-10s%-10s", accountId, accountNumber, accountName, accountPhone);
                        System.out.println(line);
                    }
                    System.out.print("Enter account id: ");
                    Long accountId = sc.nextLong();
                    Account account = new Account();
                    account.setId(accountId);

                    int recordCount = dao.delete(account);
                    if (recordCount > 0) {
                        System.out.println("An account is deleted");
                    }
                    break;
                }
                case 3:
                    List<Account> list = dao.findAll();
                    for (int i = 0; i < list.size(); i++) {
                        Long accountId = list.get(i).getId();
                        String accountNumber = list.get(i).getNumber();
                        String accountName = list.get(i).getName();
                        String accountPhone = list.get(i).getPhone();

                        String line = String.format("%-5s%-15s%-10s%-10s", accountId, accountNumber, accountName, accountPhone);
                        System.out.println(line);
                    }
                    break;
                default:
                    System.out.println("Default");
            }
        }

    } // end main
}
