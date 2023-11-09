package DynamicProgramming;

import java.util.Arrays;

/**
 * Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
 */


public class CoinChange2 {
    public static void main(String[] args) {
        // express in terms of index : index is current coin we are at
        // explore possible options : we can either use this coin, or ignore it
        // we have two states : amount, and index
        // f(i,j) should represent considering i coins to end, how many ways can we form this target j
        // ultimately f(0,amount) is what we are looking for
        int amount = 5;
        int[] coins = new int[]{1,2,5};

        int[][] dp = new int[coins.length][amount+1];
         for (int i = 0 ; i < coins.length; i++){
            Arrays.fill(dp[i],-1);
        }
        
        System.out.println(helper(coins,dp, 0,amount));
        for (int i = 0; i < coins.length; i++){
            System.out.println(i + " " + Arrays.toString(dp[i]));
        }
        System.out.println(dp[0][5]);
    }
    
    public static int helper(int[] coins, int[][] dp, int index, int target) {
        // We reached our goal already
        if (target == 0) return 1;
        if (target < 0) return 0;

        // We went past the last coin. so now we check if we reached our target or not 
        if (index >= coins.length) {
            if (target == 0){
                return 1;
            }
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];

        // We can take the coin, or we can ignore the coin. So explore both paths
        int take = helper(coins,dp, index, target - coins[index]);
        int notTake = helper(coins,dp, index+1,target);
        dp[index][target] = take + notTake;
        return take + notTake;
    }
}
