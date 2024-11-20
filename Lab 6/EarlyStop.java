/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package earlystop;
public class EarlyStop {
    public static void earlyStopBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 6, 2};
        System.out.println("Before Optimized Bubble Sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        earlyStopBubbleSort(arr);
        System.out.println("\nAfter Optimized Bubble Sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}