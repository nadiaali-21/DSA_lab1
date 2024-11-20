/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stringsortinglength;
import java.util.*;
public class StringSortingLength {
public static void bubbleSortStringsByLength(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    // Swap arr[j] and arr[j + 1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "pie", "banana", "cat"};
        System.out.println("Before Sorting:");
        for (String str : arr) {
            System.out.print(str + " ");
        }
        
        bubbleSortStringsByLength(arr);
        
        System.out.println("\nAfter Sorting :");
        for (String str : arr) {
            System.out.print(str + " ");
        }
    }
}
