package Backtracking;


import java.util.*;

//Get all possible subsets 

public class SubsetStrings {
    public static void main(String[] args) {
        char[] ch = {'a','b','c'};
        List<String> ans;
        ans = getAll("",ch,0);

        for (String s : ans) System.out.println(s);

        // abc, ab, ac, a, bc, b, c
    }

    static List<String> getAll(String curr, char[] ch, int counter){
        if (counter >= ch.length){
            List<String> arr = new LinkedList<>();
            arr.add(curr);
            return arr;
        }

        String currWith = curr + ch[counter];
        counter++;

        // Take curr and not take curr. 2 recursive calls
        List<String> left = getAll(currWith,ch,counter);
        List<String> right = getAll(curr,ch,counter);

        List<String> ans = new LinkedList<>();
        ans.addAll(left);
        ans.addAll(right);

        return ans;
    }
}
