package Misc;

public class LC1358 {
    public static void main(String[] args) {
        // String s = "aaacb";
        String s = "abcabc";
        
        char[] ch = s.toCharArray();

        int[] count = new int[3];

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < ch.length){
            if (ch[right] == 'a'){
                count[0]++;
            } else if (ch[right] == 'b') {
                count[1]++;
            } else {
                count[2]++;
            }

            
            // This means we have a valid substring..
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                // System.out.println("Right is: " + right);
                // break;

                

            }

            right++;
        }
        

    }
}
