package Misc;
import java.util.*;

public class HashTables {
    public static void main(String[] args) {


        String[] strs = {"cat","act","dog","god","car"};
        Map<String,Integer> map = new HashMap<>();
        
        // for (String s: strs){
        //     int val = map.getOrDefault(s, 1);
        //     map.put(s,val);
        // }

        for (String s: strs){
            if (map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s,1);
            }
        }


        System.out.println(map.values());
    }    
}
