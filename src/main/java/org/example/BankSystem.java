package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BankSystem {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int userChoice = 0;

        while(userChoice != 6){
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-5): ");
            userChoice = myObj.nextInt();

            switch(userChoice){
                case 1: // Creating User Account
                    System.out.print("Enter Account Number: ");
                    String userInputAccNum = myObj.next();
                    System.out.print("Enter Holder Name: ");
                    String userInputHolder = myObj.next();
                    BankAccount newAcc = new BankAccount(userInputAccNum, userInputHolder);
                    // Ask for initial deposit
                    System.out.println("Initial deposit? (yes/no): ");
                    String depositChoice = myObj.next();
                    if(Objects.equals(depositChoice, "yes")){
                        System.out.println("Enter initial deposit amount: ");
                        double initDeposit = myObj.nextDouble();
                        newAcc.deposit(initDeposit);
                    }
                    accounts.add(newAcc);
                    break;

                case 2: // View All Accounts
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        for (BankAccount acc : accounts) {
                            acc.displayInformation();
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 3: // Check Balance
                    System.out.println("Enter Account Number to Check Balance: ");



            }
        }
    }
}