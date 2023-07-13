package Misc;
import java.util.*;

public class HashS {
    public static void main(String[] args) {
        String s = "aababcabc";
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < 3; i++){
            set.add(ch[i]);    
        }
        

        if (set.size() == 3) ans++;

        for (int i = 0; i < ch.length-3; i++){
            set.remove(ch[i]);
            set.add(ch[i+3]);
            
            for (char c: set){
                System.out.print(c);
            }
            System.out.println("");
            if (set.size() == 3) ans++;
        }

        

    }
}
