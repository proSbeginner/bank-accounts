package com.pros;

import com.pros.dao.AccountDao;
import com.pros.model.Account;

import java.util.List;
import java.util.Scanner;

public class App {
    public static  void main(String[] args) {
        AccountDao dao = new AccountDao();


        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("===== Menu =====");
            System.out.println("1. Create an account");
            System.out.println("2. Get account balance");
            System.out.println("3. Show all accounts");
            System.out.print("Please choose: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    String aNumber = sc.nextLine();
                    System.out.print("Enter account name: ");
                    String aName = sc.nextLine();
                    System.out.print("Enter account phone: ");
                    String aPhone = sc.nextLine();

                    Account account = new Account();
                    account.setNumber(aNumber);
                    account.setName(aName);
                    account.setPhone(aPhone);

                    int recordCount = dao.create(account);
                    if(recordCount > 0) {
                        System.out.println("An account is created");
                    }

                    break;
                case 2:
                    System.out.println("XXXXXXX");
                    break;
                case 3:
                    List<Account> list = dao.findAll();
                    for(int i = 0; i < list.size(); i++) {
                        String accountNumber = list.get(i).getNumber();
                        String accountName = list.get(i).getName();
                        String accountPhone = list.get(i).getPhone();

                        String line = String.format("%-15s%-10s%-10s", accountNumber, accountName, accountPhone);
                        System.out.println(line);
                    }
                    break;
                default:
                    System.out.println("Default");
            }
        }

    } // end main
}
