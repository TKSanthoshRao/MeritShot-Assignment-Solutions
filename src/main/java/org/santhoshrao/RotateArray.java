package org.santhoshrao;
import java.util.Scanner;

public class RotateArray {
    /* moving part of leaderboard array from start to end */
    public static void reverse(int[] arr, int start, int end)
    {
        while (start < end){
            int temp = arr[start];   // swapping player at start and player at end
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    /* rotating leaderboard so top k players go to end */
    public static void rotate(int[] arr, int k)
    {
        int n = arr.length;
        k = k % n;         // making k valid if it is bigger than total players
        reverse(arr, 0, n - 1);   // reversing full leaderboard
        reverse(arr, 0, k - 1);   // reversing first k players
        reverse(arr, k, n - 1);   // reversing other players
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of players on leaderboard: "); // asking total players
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter player IDs in current leaderboard order:"); // taking players' IDs
        for (int i = 0; i < n; i++)
        {
            System.out.print("Player ID at position " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of top players to move to end (k): "); // asking how many top players shift
        int k = sc.nextInt();

        rotate(arr, k);   // rotating leaderboard positions

        // showing leaderboard after round rotation
        System.out.println("\nLeaderboard after moving top " + k + " players to end:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
