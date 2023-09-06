package Misc;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int[] prefix = new int[arr.length+1];
        prefix[0] = 0;

        for (int i = 1; i <= arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }

        // for (int i : prefix){
        //     System.out.println(i);
        // }

        System.out.println(query(prefix,2,4));
    }
    // prefix sum from arr[i...j] = prefix[j+1] - prefix[i]
    // Ex: sum of numbers from arr[2..4] 
    // This is taking sum of numbers from arr[0..4] - sum from arr[0..1]
    // prefix[start] = values from 0..start-1 i
    public static int query(int[] prefix, int start, int end){
        return prefix[end+1] - prefix[start];
    }
}
