package Misc;

public class StringShfit {
    public static void main(String[] args) {
        char c = 'z';
        int i = ((c - 'a') + 3) % 26;
        System.out.println((char)(i+'a'));
        
    }
}
