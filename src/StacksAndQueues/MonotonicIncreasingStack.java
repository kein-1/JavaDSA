package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;


/**
 * Monotonic Stack to find each element's next greatest element
 * O(n) time and O(n) space 
 */
public class MonotonicIncreasingStack {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 25, 7, 18};
        int[] ans = new int[arr.length];

        // Autofil it with -1 initially
        Arrays.fill(ans, 0, arr.length, -1);

        Stack<Integer> stack = new Stack<>();
        
        // Iterate through our array in one pass 
        for (int i = 0; i < arr.length; i++){

            // We pop from the stack if our CURRENT element is bigger than our TOP element 
            // When we pop, we are getting the index value. So we know that the value AT THIS INDEX
            // is less than our current element. So we assign that index in our answer to equal to our currently
            // bigger element 
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                ans[stack.pop()] = arr[i];
            }
            // We are pushing the index value 
            stack.push(i);
        }
        
        System.out.println(Arrays.toString(ans));

    }
}
