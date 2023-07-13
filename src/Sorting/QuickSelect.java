package Sorting;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,2,3,1,9,7};
        // sorted = {1,2,3,5,6,7,9}
        int val = QuickSelectHelper(arr,0,arr.length-1,4);
        System.out.println("The k'th smallest is " + val);
    }


    public static int QuickSelectHelper(int[] arr, int start, int end, int k){
        if (start == end){
            return arr[start];
        }
        int pivotIndex = partition(arr, start, end);
        if (pivotIndex == k-1){
            return arr[pivotIndex];
        } else if (pivotIndex > k - 1){
            // This means we need to look left
            return QuickSelectHelper(arr, start, pivotIndex-1, k);

        } else {
            // We need to look right
            return QuickSelectHelper(arr, pivotIndex+1, end, k);

        }


    }

    // Partitioning algorithm : 
    // We pick the last value as the partition value. 
    // Then we initialize 2 pointers : i and j. Start i = j - 1. Then we increment from j to end.
    // If our current element (which is j) is less than the pivotValue, we increment i, then swap it with the element at j
    // Otherwise, we just increment j
    // When the loop ends, we swap the element at i + 1 and our pivot element. 
    // Now we have the PIVOT element in its correct position. 
    // Now we return the pivot element's position (which is i + 1)
    public static int partition(int[] arr, int start, int end){
        int pivotValue = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++){
            if (arr[j] <= pivotValue){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i+1;
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
