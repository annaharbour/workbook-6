package com.pluralsight.finance;

import com.pluralsight.finance.models.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
//        BankAccount account1 = new BankAccount("Pam","123",  BigDecimal.valueOf(12500));
//        BankAccount account2 = new BankAccount( "Gary","456", BigDecimal.valueOf(1500));
//        account1.deposit(BigDecimal.valueOf(100));
//        account2.deposit(BigDecimal.valueOf(100));
        Scanner scanner = new Scanner(System.in);
        Portfolio portfolio = new Portfolio("Anna's Portfolio", "Anna");
        boolean running = true;

        while (running) {
            System.out.println("What would you like to do, " + portfolio.getOwner() + "?");
            String[] menuOptions = {"1) Add an asset", "2) Get Portfolio Value", "3) Get Least Valuable Asset", "4) " +
                    "Get Most Valuable Asset", "5) Exit"};
            for (String menuOption : menuOptions) {
                System.out.println("\t" + menuOption);
            }
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1:
                    addAsset(scanner, portfolio);
                    break;
                case 2:
                    System.out.printf("Value $%.2f\n", portfolio.getValue());
                    break;
                case 3:
                    System.out.println("Least Valuable Asset: \n" + portfolio.getLeaseValuable());
                    break;
                case 4:
                    System.out.println("Most Valuable Asset: \n" + portfolio.getMostValuable());
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you, goodbye!");
                    break;

            }
        }
    }

    private static void addAsset(Scanner scanner, Portfolio portfolio) {
        String[] menuOptions = {"1) Bank Account", "2) Credit Card", "3) Fixed Asset"};
        for (String option : menuOptions) {
            System.out.println(option);
        }
        int selection = scanner.nextInt();
        scanner.nextLine();
        switch (selection) {
            case 1:
                addBankAccountToPortfolio(scanner, portfolio);
                break;
            case 2:
                addCardToPortfolio(scanner, portfolio);
                break;
            case 3:
                addFixedAssetToPortfolio(scanner, portfolio);
                break;
            default:
                break;

        }

    }

    private static void addFixedAssetToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("What kind of fixed asset?");
        String[] fixedAssetOptions = {"1) Gold", "2) House", "3) Jewelry"};
        for (String fixedAsset : fixedAssetOptions) {
            System.out.println(fixedAsset);
        }
        int fixedAssetSelection = scanner.nextInt();
        scanner.nextLine();
        switch (fixedAssetSelection) {
            case 1:
                addGoldToPortfolio(scanner, portfolio);
                break;
            case 2:
                addHouseToPortfolio(scanner, portfolio);
                break;
            case 3:
                addJewelryToPortfolio(scanner, portfolio);
                break;
            default:
                break;
        }
    }

    private static void addBankAccountToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("Enter bank account number: ");
        String bankAccountNum = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter value: ");
        BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());
        BankAccount bankAccount = new BankAccount(bankAccountNum, amount);
        portfolio.add(bankAccount);
    }

    private static void addCardToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("Enter credit card number: ");
        String creditCardNum = scanner.nextLine().trim();
        System.out.println("Enter value: ");
        BigDecimal creditCardAmount = BigDecimal.valueOf(scanner.nextDouble());
        CreditCard card = new CreditCard(creditCardNum, creditCardAmount);
        portfolio.add(card);
    }

    private static void addJewelryToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("Jewelry name: ");
        String jewelryName = scanner.nextLine();
        System.out.println("Market value: ");
        BigDecimal jewelryMarketValue = BigDecimal.valueOf(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Karats: ");
        double karat = scanner.nextDouble();
        scanner.nextLine();
        Jewelry jewelry = new Jewelry(jewelryName, jewelryMarketValue, karat);
        portfolio.add(jewelry);
    }

    private static void addHouseToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("House name: ");
        String houseName = scanner.nextLine();
        System.out.println("Current market value per sq ft: ");
        BigDecimal houseMarketVal = BigDecimal.valueOf(scanner.nextDouble());
        System.out.println("When was it built?");
        int yearBuilt = scanner.nextInt();
        System.out.println("How many square feet?");
        int squareFeet = scanner.nextInt();
        System.out.println("How many bedrooms?");
        int numBeds = scanner.nextInt();
        scanner.nextLine();
        House house = new House(houseName, houseMarketVal, yearBuilt, squareFeet, numBeds);
        portfolio.add(house);
    }

    private static void addGoldToPortfolio(Scanner scanner, Portfolio portfolio) {
        System.out.println("Gold name: ");
        String goldName = scanner.nextLine();
        System.out.println("Current market value of gold: ");
        BigDecimal marketVal = BigDecimal.valueOf(scanner.nextDouble());
        System.out.println("How much gold?");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        Gold gold = new Gold(goldName, marketVal, weight);
        portfolio.add(gold);
    }
}