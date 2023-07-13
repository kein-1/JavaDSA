package Sorting;

import java.util.Arrays;


/**
 * Selection sort: find the smallest element, then put it at the the start. Then we shrink our array space by 1. I'm using a recursive approach here 
 * Time complexity: O(n^2). The worst case is n^2 since we need to go through the array n times to find the largest element, and each time there are n elements to look at 
 */


public class SelectionSort {
    
    public static void selectionSort(int start, int end, String[] arr){
        if (start > end){
            return;
        }
        int index = getMinIndex(start, end, arr);
        swapValues(start, index, arr);
        selectionSort(++start, end, arr);
    }

    // Returns the min value's index location
    public static int getMinIndex(int start, int end, String[] arr){
        String min = arr[start];
        int minIndex = start;
        for (int i = start; i < end; i++){
            if (min.compareTo(arr[i+1]) > 0){
                minIndex = i+1;
                min = arr[i+1];
            }
        }
        return minIndex;
    }

    public static void swapValues(int x, int y, String[] arr){
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        String[] stringArr1 = {"cat", "lion", "dog", "tiger", "fish", "lobster"};
        selectionSort(0, stringArr1.length-1, stringArr1);
        System.out.println(Arrays.toString(stringArr1));
    }

}
