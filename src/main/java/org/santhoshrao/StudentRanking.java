package org.santhoshrao;
import java.util.Scanner;

public class StudentRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");  // Taking User input for number of students
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.println("\nEnter marks for each student:");  // Taking marks into the array
        for (int i = 0; i < n; i++) {
            System.out.print("Marks of student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Sorting in Descending Order using Selection Sort
        for (int i = 0; i < n - 1; i++){
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swapping the variables
            int temp = marks[i];
            marks[i] = marks[maxIdx];
            marks[maxIdx] = temp;
        }

        System.out.println("\nUpdated Marks (Descending Order):"); // Displaying updated Student Marks in Descending order
        for (int i = 0; i < n; i++) {
            System.out.print(marks[i] + " ");
        }
    }
}
