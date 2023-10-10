package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // Run QuickSort
        // Divide and Conquer Algorithm 
        // pivot elemnt : pick any pivot. Typically pick last value 
        // Two pointers : i, and pivot index. i is used to find all elements less than the pivot element
        // pivot index serves as the partition index for where we would put the pivot element 
        // Search from 0 to n - 1. 
        // At each iteration, if i is less than pivot element, swap arr[i] with arr[pivotIndex], then increment
        // pivotIndex
        // pivotIndex is used to serve as sorting all elements smaller than pivot element and greater than pivot element
        // At the end of iteration, swap arr[pivotIndex] with arr[pivotElement]. The pivotIndex will serve as the correct location
        // for the pivot element
        // pivot element is now sorted and in its correct location but all elements to the left and to the right may not be sorted
        // So recursively call algorithm on quicksort(start,pivotIndex-1) and quicksort(pivotIndex+1,end)

        int[] arr = new int[]{7,2,1,6,8,5,3,4};
        QuickSortMain(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    public static void QuickSortMain(int[] arr, int start, int end){
        System.out.println("calling : " + start + " " + end );
        if (start >= end) return;

        // Do sorting and then get the partition index
        int partitionIndex = getPartitionIndex(arr, start, end);
        System.out.println("Partition index and sorted array: " + partitionIndex + " " + Arrays.toString(arr));
        

        // Make 2 recursive calls 
        QuickSortMain(arr, start, partitionIndex - 1);
        QuickSortMain(arr, partitionIndex + 1, end);

    }


    public static int getPartitionIndex(int[] arr, int start, int end){
        // Partition index serves as the pointer to put all elements smaller than pivotElement to the left of it by 
        // swapping it with i. move partitionIndex after swap 
        // i is used to find elements. if element is bigger, ignnore and go on 
        int partitionIndex = start;
        int pivotElement = arr[end];
        // Iterate from 0 up to end-1
        for (int i = start; i <= end - 1; i++){
            if (arr[i] <= pivotElement){
                swap(arr,i,partitionIndex);
                partitionIndex++;
            }
        }   
        // Swap the element at partition index and the last element, which is pivot element's location
        // Now pivotelement will be in the correct location
        swap(arr,partitionIndex,end);
        return partitionIndex;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
