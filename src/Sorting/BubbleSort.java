package Sorting;

import java.util.Arrays;


/**
 * Bubble sort: find the largest element, then put it at the end. Then we shrink our array space by 1. I'm using a recursive approach here 
 * Time complexity: O(n^2). The worst case is n^2 since we need to go through the array n times to find the largest element, and each time there are n elements to look at 
 */

public class BubbleSort {
    
    public static void bubbleSort(int start, int end, String[] arr){
        if (start > end){
            return;
        }
        int index = getMaxIndex(start, end, arr);
        swapValues(index, end, arr);
        bubbleSort(start, --end, arr);
    }

    // Returns the max value's index location
    public static int getMaxIndex(int start, int end, String[] arr){
        String max = arr[start];
        int maxIndex = start;
        for (int i = 0; i < end; i++){
            if (max.compareTo(arr[i+1]) < 0){
                maxIndex = i+1;
                max = arr[i+1];
            }
        }
        return maxIndex;
    }

    public static void swapValues(int x, int y, String[] arr){
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        String[] stringArr1 = {"cat", "lion", "dog", "tiger", "fish", "lobster"};
        bubbleSort(0, stringArr1.length-1, stringArr1);
    }

}
