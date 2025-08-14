package org.santhoshrao;
import java.util.*;

// Q1: Sales Report Analysis

public class SalesReportAnalysis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Getting user input for number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int sales[] = new int[n];

        // Taking input from user into sales data Array data structure
        System.out.println("Enter sales for each day:");
        for(int i = 0; i < n; i++){
            sales[i] = sc.nextInt();
        }

        // Initializing max, min, and sum variables for tracking of these values from throughout the Array
        int max = sales[0];
        int min = sales[0];
        int sum = 0;

        // Finding max, min and sum manually
        for(int i = 0; i < n; i++){
            if (sales[i] > max)
            {
                max = sales[i];
            }
            if(sales[i] < min){
                min = sales[i];
            }
            sum += sales[i];
        }

        // Calculating average
        double avg = (double)sum/n;

        // Display results
        System.out.println("\n----- Sales Report -----");
        System.out.println("Maximum Sales: " + max);
        System.out.println("Minimum Sales: " + min);
        System.out.printf("Average Sales: %.2f\n", avg);
    }
}
