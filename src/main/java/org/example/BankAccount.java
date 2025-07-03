package org.example;

public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double availableBalance;

    /*
    Methods:
    Deposit: Adds to balance (with error check)
    Withdraw: Subtracts from balance (with error check)
    Display Information:Prints account info
    Get Account Number: Returns account number (used for searching)
     */

    public BankAccount(String accountNumber, String accountName, double availableBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.availableBalance = availableBalance;
    }

    public BankAccount(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }
    public BankAccount(double availableBalance){
        this.availableBalance = availableBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.availableBalance += amount;
            System.out.println("Deposit successful! New balance: $" + this.availableBalance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(){

    }

    public void displayInformation() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountName);
        System.out.println("Available Balance: $" + availableBalance);
    }


    public void getAccountNumber(){

    }

}
