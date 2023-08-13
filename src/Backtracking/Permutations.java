package Backtracking;

import java.util.*;

public class Permutations{
    public static void main(String[] args) {
        String str = "abc";
        List<String> list = permutations("", str);
        for (String s : list) System.out.println(s);
    }


    public static List<String> permutations (String curr, String str){
        if (str.isEmpty()){
            List<String > list = new LinkedList<>();
            list.add(curr);
            return list;
        }
        
        List<String> ans = new LinkedList<>();

        int size = curr.length()+1;
        char c = str.charAt(0);
        
        // We need to pass a different curr to each recursive call. 
        for (int i = 0; i < size; i++){
            String emp = curr.substring(0,i) + c + curr.substring(i, curr.length());

            List<String> val = permutations(emp,str.substring(1));
            ans.addAll(val);
        }
        return ans;

    }   
}