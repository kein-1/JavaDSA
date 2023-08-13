package Misc;
// I want to find the pairs of elements whose difference is K
import java.util.*;
// example k=4 and a[]={7 ,6 23,19,10,11,9,3,15}
// output should be :
//    7,11
//    7,3
//    6,10
//    19,23
//    15,19
//    15,11
public class FindPair {
    public static void main(String[] args) {

        // Plan : go throguh array and record the index : O(n)
        // Then go through array again. Now look for each element + k. If that element exists in the hashmap, get the pairs
        int[] arr = new int[]{7,6,23,19,10,11,9,3,15};
        int k = 4;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i],i);
        }

        for (int i : arr){
            if (map.containsKey(i + k)){
                System.out.println(i + " " + (i+k));
            }
        }
    }
}
