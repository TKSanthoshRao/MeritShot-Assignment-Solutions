package org.santhoshrao;
import java.util.Scanner;

public class KSmallestElements{
    // making min heap from array
    public static void minheap(int[] arr, int n){
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // heap property for min heap
    public static void heapify(int[] arr, int n, int i){
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] < arr[smallest]){
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

    // function for finding k smallest elements
    public static void findKSmallest(int[] arr, int n, int k){
        minheap(arr, n);
        System.out.println("\nSmallest " + k + " elements are:");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[0] + " ");    // printing root because it will be smallest element
            arr[0] = arr[n - 1 - i];          // moving last element to root

            heapify(arr, n - 1 - i, 0);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");    // asking how many numbers in array
        int n = sc.nextInt();
        int[] arr = new int[n];
        // taking array elementsI
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // asking for k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        findKSmallest(arr, n, k);
    }
}

