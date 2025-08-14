package org.santhoshrao;
import java.util.Scanner;

public class KSmallestElements {
    /* making min heap from prices array */
    public static void minheap(int[] arr, int n){
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /* keeping min heap property for prices */
    public static void heapify(int[] arr, int n, int i){
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] < arr[smallest]){
            smallest = left;
        }
        if(right < n && arr[right] < arr[smallest]){
            smallest = right;
        }
        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, n, smallest);
        }
    }

    public static void findKSmallest(int[] arr, int n, int k){ // finding k cheapest prices
        minheap(arr, n);
        System.out.println("\nCheapest " + k + " item prices are:");
        for (int i = 0; i < k; i++){
            System.out.print(arr[0] + " "); // printing root because it is smallest price
            arr[0] = arr[n - 1 - i];        // moving last price to root
            heapify(arr, n - 1 - i, 0);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of items in shop: "); // total items in shop
        int n = sc.nextInt();
        int[] arr = new int[n];

        // taking item prices
        System.out.println("Enter the price of each item:");
        for(int i = 0; i < n; i++){
            System.out.print("Price of item " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter how many cheapest items to display (k): "); // asking user for k
        int k = sc.nextInt();
        findKSmallest(arr, n, k);
    }
}
