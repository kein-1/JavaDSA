package DynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {

        /**
         * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. 
         * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
         * For example, if the length of the rod is 8 and the values of different pieces are given as the following, 
         * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 
         */
        // Pattern is UnboundedKnapsack
        //                      0 1 2 3 4 5 6 7 8
        int[] price = new int[]{1,5,8,9,10,17,17,20};
        int length = 8;
        
        // Add memoization : dp[i][j] refers to the maxx profit we can make considering i elements at this given length
        int[][] dp = new int[length+1][length+1]; 
        System.out.println((helper(price,dp, 8,price.length - 1)));

    }

    public static int helper(int[] price, int[][] dp, int length, int index){
        // length is target here. So starting from an initial length of 8 : 
        // we want to explore all possibilities. With length of 8, we either sell it at this length, or we don't sell
        // what is the current length  ? the current length we cut is the current index + 1. 
        // Thus if we ignore the cut, we are essentially using a smaller length cut
        
        // Similar to coin change II. In that problem, we are counting the number of ways to form the target coins. So our function
        // was f(index,target) and at each recursive call, we have two choices : we either take the coin, or we ignore it. 
        // If we take, we can reuse. If we ignore, we move to the smaller set 

        // Ex : f(3, 12) -> Recurrence is considering the first 4 indices, how many ways can we make a target of 12 ?
        // this will depend on how many ways we can make it with a target by taking the current coin + the number of ways
        // we can make it by not taking the current coin

        // F(n) = F(index,target-coin[index]) + F(index-1,target) 
        
        if (index < 0){
            // We cannot cut naymore, so return 0
            return 0; 
        }
        
        if (dp[index][length] != 0) return dp[index][length];
        // cut : set initial cut to int min since we only cut if rod length is shorter than what we currently have; we can't cut a rod length longer
        int cut = Integer.MIN_VALUE;

        // rod length depends on index. the current rod length is index + 1 since lengths start at 1
        int rodLength = index + 1;

        // We choose to cut at this current length. So we take the price, then we reduce to seeing how much we can make
        // with the remaining length
        if (rodLength <= length){
            cut = price[index] + helper(price,dp, length - rodLength, index);
        }
        int notCut = helper(price,dp, length, index-1);
        dp[index][length] = Math.max(cut,notCut);
        return Math.max(cut,notCut);
    }
}
