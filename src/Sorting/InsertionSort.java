package Sorting;

import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,3,1,2,6,9,0};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Insrtion sort : sort from i to j
    public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int j = i + 1;

            while (j > 0 && arr[j] < arr[j-1]){
                swap(arr, j, j-1);
                j--;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("");
        }
    }


    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
}
