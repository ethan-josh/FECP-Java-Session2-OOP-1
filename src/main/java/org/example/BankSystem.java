package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BankSystem {

    public static int goBackMenu(String choice){
        if(choice.equalsIgnoreCase("yes")){
            return 2;
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int userChoice = 0;
        int menuOption;

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
                    System.out.print("Initial deposit? (yes/no): ");
                    String depositChoice = myObj.next();
                    if(Objects.equals(depositChoice, "yes")) {
                        System.out.print("Enter initial deposit amount: ");
                        double initDeposit = myObj.nextDouble();
                        newAcc.deposit(initDeposit);
                    }
                    accounts.add(newAcc);

                    System.out.println("Account created successfully!");

                    System.out.print("Would you like to retrun to the menu? (yes/no): ");
                    String userMenu = myObj.next();
                    menuOption = goBackMenu(userMenu);
                    if(menuOption == 1){
                        userChoice = 6;
                    }
                    System.out.println();
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
                    System.out.print("Would you like to retrun to the menu? (yes/no): ");
                    String userMenu2 = myObj.next();
                    menuOption = goBackMenu(userMenu2);
                    if(menuOption == 1){
                        userChoice = 6;
                    }
                    System.out.println();
                    break;

                case 3: // Check Balance
                    System.out.print("Enter Account Number to Check Balance: ");
                    String searchNum = myObj.next();

                    boolean accFound = false;
                    if (accounts.isEmpty()){
                        System.out.println("No account created.");
                        System.out.print("Would you like to retrun to the menu? (yes/no): ");
                        String userMenu3 = myObj.next();
                        menuOption = goBackMenu(userMenu3);
                        if(menuOption == 1){
                            userChoice = 6;
                        }
                        System.out.println();
                        break;

                    }
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(searchNum)){
                            System.out.printf("Available Balance: %.2f", acc.getAvailableBalance());
                            System.out.println();
                            accFound = true;
                            break;
                        }
                    }
                    System.out.print("Would you like to retrun to the menu? (yes/no): ");
                    String userMenu3 = myObj.next();
                    menuOption = goBackMenu(userMenu3);
                    if(menuOption == 1){
                        userChoice = 6;
                    }
                    System.out.println();
                    break;

                case 4: // Deposit
                    System.out.print("Enter Account Number to Deposit Into: ");
                    String depositAccNum = myObj.next();
                    if (accounts.isEmpty()){
                        System.out.println("No account created.");
                        System.out.print("Would you like to retrun to the menu? (yes/no): ");
                        String userMenu4 = myObj.next();
                        menuOption = goBackMenu(userMenu4);
                        if(menuOption == 1){
                            userChoice = 6;
                        }
                        System.out.println();
                        break;

                    }
                    boolean depositFound = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(depositAccNum)) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = myObj.nextDouble();
                            acc.deposit(depositAmount);
                            depositFound = true;
                        }
                    }

                    if (!depositFound) {
                        System.out.println("Account not found.");
                    }

                    System.out.print("Would you like to retrun to the menu? (yes/no): ");
                    String userMenu4 = myObj.next();
                    menuOption = goBackMenu(userMenu4);
                    if(menuOption == 1){
                        userChoice = 6;
                    }
                    System.out.println();
                    break;

                case 5: // Withdraw
                    System.out.print("Enter Account Number to Withdraw From: ");
                    String withdrawAccNum = myObj.next();
                    if (accounts.isEmpty()){
                        System.out.println("No account created.");
                        System.out.print("Would you like to retrun to the menu? (yes/no): ");
                        String userMenu5 = myObj.next();
                        menuOption = goBackMenu(userMenu5);
                        if(menuOption == 1){
                            userChoice = 6;
                        }
                        System.out.println();
                        break;

                    }
                    boolean withdrawFound = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(withdrawAccNum)) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = myObj.nextDouble();
                            System.out.println();
                            acc.withdraw(withdrawAmount);
                            withdrawFound = true;

                            System.out.print("Would you like to retrun to the menu? (yes/no): ");
                            String userMenu5 = myObj.next();
                            menuOption = goBackMenu(userMenu5);
                            if(menuOption == 1){
                                userChoice = 6;
                            }
                            System.out.println();
                            break;
                        }
                    }

                    if (!withdrawFound) {
                        System.out.println("Account not found.");
                        System.out.print("Would you like to retrun to the menu? (yes/no): ");
                        String userMenu5 = myObj.next();
                        menuOption = goBackMenu(userMenu5);
                        if(menuOption == 1){
                            userChoice = 6;
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}