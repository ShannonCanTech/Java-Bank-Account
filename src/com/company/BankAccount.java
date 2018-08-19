package com.company;

import java.util.Random;

public class BankAccount {
    private int acctNum;
    private int balance;
    private int prevBalance = -1;
    Random rand;
    Person person;

    public BankAccount() {
    }

    public BankAccount(int acctNum, int balance) {
        this.acctNum = acctNum;
        this.balance = balance;
    }

    public int getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void deposit(int addMoney){
        if(addMoney < 0){
            System.out.println("You cannot deposit a negative amount.");
        } else {
            this.balance = this.balance + addMoney;
            System.out.println("$" + addMoney + " deposited into the account number " + this.acctNum);
        }
    }

    public void withdraw(int removeMoney){
        if (removeMoney > this.balance){
            System.out.println("Not enough money in account");
        } else {
            this.prevBalance = this.balance;
            this.balance = this.balance - removeMoney;
            System.out.println("Previous balance: " + prevBalance + "\nWithdrawn amount: " + removeMoney + "\nYour current balance is: " + this.balance);
        }
    }

//The method below creates a new account number and assigns it to the String person
//    This method doesn't take an integer as an argument because we don't want to assign an account number to an account number
//    The String person argument is perfect, so when we set Person using the person object in the main method, we'll be able to
//    store the person object and assign them to an account number
    public int createNewAcctNum(String person) {
        rand = new Random();
//        The code below generates no more than 12 random numbers and stores them into the account number
        for (int i = 0; i < 12; i++){
            this.acctNum = this.rand.nextInt() & Integer.MAX_VALUE;
        }
        person = Integer.toString(this.acctNum);
        return this.acctNum;
    }
}
