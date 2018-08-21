/*The code below create 1 bank account for 1 person
* and allows them to:
* 1. Create a bank account
* 2. Make an initial deposit
* 3. Make a withdrawal
* 4. Make multiple transactions */

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
            } catch (InputMismatchException e1) { //If the user inputs a value that either isn't an integer or is too big of an integer
                System.out.println("Invalid entry. Must input a valid integer value.");
                invalid = true;
            } catch (Exception e2){ //Catches all other exceptions
                System.out.println("Invalid entry.");
                invalid = true;
            }

//          Ask the user this only if invalid is false, otherwise, if invalid is true, exit program
            if (invalid == false) {
                System.out.println("Would you like to make another transaction? (Y/N)");
                String answer = scan.nextLine();
                if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("YES")){
                    continue;
                } else {
                    break;
                }
            }

        }while(!invalid);

        newAccount.showAccountDetails();
    }
}
