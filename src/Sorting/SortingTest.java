package Sorting;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class SortingTest {
    @Test
    public void bubbleSortTest(){
        String[] stringArr1 = {"cat", "lion", "dog", "tiger", "fish", "lobster"};

        BubbleSort.bubbleSort(0,stringArr1.length-1, stringArr1);
        String[] expected = {"cat", "dog", "fish", "lion", "lobster", "tiger"};

        assertArrayEquals(expected,stringArr1);
        
    }

    @Test
    public void selectionSortTest(){
        String[] stringArr1 = {"cat", "lion", "dog", "tiger", "fish", "lobster"};
        String[] expected = {"cat", "dog", "fish", "lion", "lobster", "tiger"};
        SelectionSort.selectionSort(0, stringArr1.length-1, stringArr1);
        assertArrayEquals(expected, stringArr1);

    }

    @Test
    public void mergingTwoArraysTest(){
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{5,6,7,8};

        int[] expectedArr = new int[]{1,2,3,4,5,6,7,8};
        int[] resultArr = MergeSort.mergeArrays(arr1, arr2);
        assertArrayEquals(expectedArr, resultArr);


        int[] arr3 = new int[]{0,0,0};
        int[] arr4 = new int[]{1,2,3};
        int[] expectedArr2 = new int[]{0,0,0,1,2,3};

        int[] resultArr2 = MergeSort.mergeArrays(arr3, arr4);


        assertArrayEquals(expectedArr2, resultArr2);


    }
    @Test
    public void mergeSortTest(){
        // Array with 10 elements 
        int[] arr1 = new int[]{13,3,15,12,6,14,9,11,17,2};
        int[] expectedArr1 = new int[]{2,3,6,9,11,12,13,14,15,17};
        
        int[] mergedArray1 = MergeSort.mergeSort(arr1, 0, arr1.length-1);
        assertArrayEquals(expectedArr1, mergedArray1);


        // Array with 9 elements 
        int[] arr2 = new int[]{17,15,4,11,19,5,16,12,20};
        int[] expectedArr2 = new int[]{4,5,11,12,15,16,17,19,20};

        int[] mergedArray2 = MergeSort.mergeSort(arr2, 0, arr2.length-1);
        assertArrayEquals(expectedArr2, mergedArray2);




    }

}
