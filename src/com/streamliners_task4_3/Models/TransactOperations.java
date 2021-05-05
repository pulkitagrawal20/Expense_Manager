package com.streamliners_task4_3.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TransactOperations {
    private static Scanner sc = new Scanner(System.in);
    public static HashMap<String, ArrayList<Transactions>> transactions;
    public static ArrayList<Transactions> transaction;

    public TransactOperations(){

    }
    public class TransactionType{
        public static final int TYPE_Expense=2,TYPE_Income=1;
    }

    //class for adding transactions:
    public static void addTransaction() {
        transactions = new HashMap<>();
        transaction = new ArrayList<>();


        //options list:
        System.out.println(" Select Transaction Type:" +
                "\n1: INCOME" +
                "\n2: EXPENSE");
        //Entering data according to choice:
        System.out.println("Enter your choice");
        int type = sc.nextInt();
        //entering transaction type:
        if (type == TransactionType.TYPE_Income) {
            System.out.println("Income Saved Successfully");
        } else if (type == TransactionType.TYPE_Expense) {
            System.out.println("Transaction Saved As Expenditure Successfully");
        }
        //Entering amount:
        System.out.println("Enter Amount:");
        float amount = sc.nextFloat();

        //Entering Date:
        System.out.println("Enter Date (yyyy-mm-dd):");
        String date = sc.next();

        //Entering info:
        System.out.println("Enter the info:");
        String info = sc.next();

        //Object added for class transaction:
        Transactions trans = new Transactions(amount, type, date, info);
        transaction.add(trans);
        LocalDate dates = LocalDate.parse(trans.date, DateTimeFormatter.ISO_DATE);
        String key = dates.getMonth().toString() + "" + dates.getYear();
        System.out.println(key);

        //checking for the transaction in a month:
        if (transactions.containsKey(key)) {
            transactions.get(key).add(trans);
        } else {
            ArrayList<Transactions> list = new ArrayList<>();
            list.add(trans);
            transactions.put(key, list);
        }
        System.out.println("Transaction Added Successfully!!!");
    }

    // class for deleting transactions
    public static void deleteTransaction() {
        System.out.println("Enter the Month and Year of transaction to delete:(ex: March 2021)");
        String key = sc.nextLine();
        while (key.isEmpty())
            key = sc.nextLine();

        //Checking the correct month and year:
        if (!transactions.containsKey(key)) {
            System.out.println("Error!! Transaction doesn't Exists,plz!! Check the Details you entered ");
        }
        else {
            //Getting and printing all the transactions of entered month:
            ArrayList<Transactions> MonthTransactions = new ArrayList<>();
            MonthTransactions = transactions.get(key);

            for (int i = 0; i < MonthTransactions.size(); i++) {
                System.out.println((i + 1) + "." + MonthTransactions.get(i));
            }
            System.out.println("Choose from the list above:");
            int choose = sc.nextInt();
            Transactions trans1 = MonthTransactions.get(choose - 1);

            //remove the selected transaction
            MonthTransactions.remove(trans1);
            System.out.println("Transaction Deleted!!");
        }

    }

    //class for Editing any transaction:
    public static void editTransaction() {
        System.out.println("Enter the Month and Year of transaction to Edit:(ex: March 2021)");
        String key = sc.nextLine();
        while (key.isEmpty())
            key = sc.nextLine();

        //Checking the correct month and year:
        if (!transactions.containsKey(key)) {
            System.out.println("Error!! Transaction doesn't Exists,plz!! Check the Details you entered ");
        }
        else {
            //Getting and printing all the transactions of entered month:
            ArrayList<Transactions> MonthTransactions = new ArrayList<>();
            MonthTransactions = transactions.get(key);
            for (Transactions trans1 :MonthTransactions) {
                System.out.println(trans1);
            }
            System.out.println("Choose from the list above:");
            int choose = sc.nextInt();
            Transactions trans1 = MonthTransactions.get(choose - 1);
            //entering edited array:
            System.out.println("Enter The new Amount:");
            trans1.amount = sc.nextFloat();

            //Entering Date:
            System.out.println("Enter New Date (yyyy-mm-dd):");
            trans1.date = sc.next();

            //Entering info:
            System.out.println("Enter the New info:");
            trans1.info = sc.next();

            System.out.println("Transation Updated!!");
        }
    }

    //Getting details of transaction my entering month:
    public static void getTransaction() {
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        System.out.println("Enter The Month and Year for Details:(ex: March 2021)");
        String key = sc.nextLine();
        while (key.isEmpty())
            key = sc.nextLine();

        if (!transactions.containsKey(key)) {
            System.out.println("Error!! Transaction doesn't Exists,plz!! Check the Details you entered ");
        } else {
            //Getting and printing all the transactions of entered month:
            ArrayList<Transactions> MonthTransactions = new ArrayList<>();
            MonthTransactions = transactions.get(key);

            for (int i = 0; i < MonthTransactions.size(); i++) {
                System.out.println((i + 1) + "." + MonthTransactions.get(i));
            }
        }
    }
    //Summary Of all the Transaction in Month:
    public static void Summary(){
        transactions = new HashMap<>();
        transaction = new ArrayList<>();
        System.out.println("Enter The Month and Year for Details:(ex: March 2021)");
        String key = sc.nextLine();
        while (key.isEmpty())
            key = sc.nextLine();
        float expend=0;
        float earned=0;
        float overall=earned-expend;

        //calculate overall income and saving:
        if(!transactions.containsKey(key)){
            System.out.println("Error!! Transaction doesn't Exists,plz!! Check the Details you entered ");
        }
        else{
            ArrayList<Transactions> MonthTransactions = new ArrayList<>();
            MonthTransactions= transactions.get(key);
            for(Transactions MonthTransaction:MonthTransactions){
                if(MonthTransaction.tranType==TransactionType.TYPE_Income){
                    earned+=MonthTransaction.amount;
                    System.out.println("\n Earning:"+earned);
                }
                else{
                    expend+=MonthTransaction.amount;
                    System.out.println("\n Expends"+expend);
                }
            }
            System.out.println("\n Overall Saving:"+overall);
        }
    }
}