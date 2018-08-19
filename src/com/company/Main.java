package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean invalid = false;
	    Scanner scan = new Scanner(System.in);
	    Person person = new Person();
        BankAccount newAccount = new BankAccount();

        System.out.println("Enter your name: ");
        person.setFullName(scan.nextLine());
        newAccount.createNewAcctNum(person.getFullName());
        System.out.println(newAccount.getAcctNum());
        do {
            try {

                System.out.println("Add balance: ");
                int depositAmount = newAccount.deposit(scan.nextInt());
                scan.nextLine();

                System.out.println("Account balance: " + newAccount.getBalance());

                if (depositAmount > 0) {
                    System.out.println("Withdrawal amount: ");
                    newAccount.withdraw(scan.nextInt());
                    scan.nextLine();

                    System.out.println("Account balance: " + newAccount.getBalance());
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Must input an integer value.");
                invalid = true;
            }

            System.out.println("Would you like to make another transaction? (Y/N)");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")){
                continue;
            } else {
                break;
            }
        }while(!invalid);

        newAccount.showAccountDetails();
    }
}
