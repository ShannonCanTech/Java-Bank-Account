package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    Person person = new Person();
        BankAccount newAccount = new BankAccount();

        System.out.println("Enter your name: ");
        person.setFullName(scan.nextLine());

        newAccount.createNewAcctNum(person.getFullName());
        System.out.println(newAccount.getAcctNum());

        System.out.println("Add balance: ");
        newAccount.deposit(scan.nextInt());
        scan.nextLine();

        System.out.println("Account balance: " + newAccount.getBalance());

        System.out.println("Withdrawal amount: ");
        newAccount.withdraw(scan.nextInt());
        scan.nextLine();

        System.out.println("Account balance: " + newAccount.getBalance());
    }
}
