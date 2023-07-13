package Sorting;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = {5,10,2,3,21,19,1};

        int[] test1 = {9,10,20};
        int[] test2 = {2,9};

        System.out.println(Arrays.toString(mergeSort(arr,0,6)));

    }

    public static int[] mergeSort(int[] arr,int left, int right){
        if (left == right){
            int[] temp = new int[]{arr[left]};
            return temp;
        }
        
        int mid = left + (right-left)/2;
        
        int[] leftArr = mergeSort(arr,left,mid);
        int[] rightArr = mergeSort(arr,mid+1,right);

        return merge(leftArr,rightArr);
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;

        int[] ans = new int[size1+size2];
        int curr = 0;

        int p1 = 0;
        int p2 = 0;

        while (p1 < size1 && p2 < size2){
            if (arr1[p1] < arr2[p2]){
                ans[curr] = arr1[p1];
                p1++;
            } else {
                ans[curr] = arr2[p2];
                p2++;
            }
            curr++;
        }
        
        if (p1 < size1){
            while (p1 < size1){
                ans[curr] = arr1[p1];
                p1++;
                curr++;
            }
        } else {
            while (p2 < size2){
                ans[curr] = arr2[p2];
                p2++;
                curr++;
            }
        }
        return ans;

    }
}
