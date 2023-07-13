package Sorting;

import java.util.Arrays;


/**
 * Merge sort: divide and conquer algorithm. The goal is to keep dividing your array until you reach 1 element, then return this base case
 * Once the elements are returned, we merge the two arrays and return a new array
 * Time complexity: O(n log n). The number of times we divide is log n, since each step we are halfing the array. At each level, we are making n comparisons 
 * This implementation uses a recursive approach and creates a new array. An alternative is to MergeSort in place, which is tougher 
 */
public class MergeSort {
    
    // The main sorting method 
    public static int[] mergeSort(int[] arr, int start, int end){

        //Base case. Return an array of size 1
        if (start >= end){
            int[] singleArr = new int[]{arr[start]};
            return singleArr;
        }
        int middle = (start) + (end-start)/2;
        
        // Call merge sort on the left half and the right half 
        int[] arr1 = mergeSort(arr,start, middle);
        int[] arr2 = mergeSort(arr,middle+1, end);
        
        // Merge the two returned arrays 
        int[] mergedArrays = mergeArrays(arr1, arr2);
        return mergedArrays;
    }


    // Merging two arrays. Return a sorted, merged array 
    public static int[] mergeArrays(int[] arr1, int[] arr2){
        if (arr1 == null){
            return arr2;
        }
        if (arr2 == null){
            return arr1;
        }
        int size = arr1.length + arr2.length;
        int[] mergedArr = new int[size];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length){
            if (arr1[p1] < arr2[p2]){
                mergedArr[p3] = arr1[p1];
                p1++;
            } else {
                mergedArr[p3] = arr2[p2];
                p2++;
            }
            p3++;
        }

        if (p1 >= arr1.length){
            while (p2 < arr2.length){
                mergedArr[p3] = arr2[p2];
                p2++;
                p3++;
            }
        } else {
            while (p1 < arr1.length){
                mergedArr[p3] = arr1[p1];
                p1++;
                p3++;
            }
        }
        return mergedArr;

    }
    public static void main(String[] args) {
        int[] arr = {4, 14, 8, 14, 19, 16, 13, 2, 3, 1};
        int[] mergedArr = mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(mergedArr));

    } 
}
