package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;


/**
 * Monotonic Stack to find each element's next greatest element
 * This method starts from the back of the array 
 * O(n) time and O(n) space 
 */
public class MonotonicIncreasingStack2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 25, 7, 18};
        int[] ans = new int[arr.length];

    
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length-1; i >= 0; i--){

            while (!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        System.out.println(Arrays.toString(ans));

    }
}
