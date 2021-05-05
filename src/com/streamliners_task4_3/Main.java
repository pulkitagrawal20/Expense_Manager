package com.streamliners_task4_3;

import java.util.Scanner;
import static com.streamliners_task4_3.Models.TransactOperations.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\nPlease choose from the given options: " +
                "\n0: To exit Application" +
                "\n1: New Transaction" +
                "\n2: Edit Transaction" +
                "\n3: Remove Transaction" +
                "\n4: See All Transactions" +
                "\n5: Summary of Transactions";

        //Options Chosen from the given menu:
        System.out.println(menu);
        int options = sc.nextInt();
        while (true){
            switch (options) {
                case 0:
                    System.out.println("Application Closed!!");
                    break;
                case 1:
                    addTransaction();
                    break;
                case 2:
                    editTransaction();
                    break;
                case 3:
                    deleteTransaction();
                    break;
                case 4:
                    getTransaction();
                    break;
                case 5:
                    Summary();
                    break;
                default:
                    System.out.println("Invalid Option, pls choose from the given option:");
                    break;
            }
            System.out.println("Enter your choice:-");
            options= sc.nextInt();
        }

    }
}
