package DynamicProgramming;

/**
 * Given an input n, design and analyze a dynamic programming algorithm to count the number of binary
strings of length n that do not contain two consecutive 1’s.

Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101
 */

public class CountBinaryStrings {
    public static void main(String[] args) {
        // at each step, we can either be a 1 or a 0
        // if we are a 0, what can our next char be ? it can be a 0 or 1.
        // if we are a 1, then our next char can only be a 0
        // index : last char that is used 
        // base case : when length is > N

        int n = 2;
        int count1 = CountBinaryStrings(n,1,'0');
        int count2 = CountBinaryStrings(n,1,'1');
        System.out.println(count1 + count2);
    }    

    public static int CountBinaryStrings(int n, int index, char lastChar){
        if (index >= n){
            return 1;
        }

        // Next string we generate can only start with 0 
        if (lastChar == '1'){
            int count1 = CountBinaryStrings(n, index+1, '0');
            return count1;
        } else {

            // Otherwise, we can have 01 or 10.. so explore both 
            int count1 = CountBinaryStrings(n, index+1, '0');
            int count2 = CountBinaryStrings(n, index+1, '1');
            return count1 + count2;
        }
    }




}
