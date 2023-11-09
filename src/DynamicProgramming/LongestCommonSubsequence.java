package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";
        int ans = LCS(s,t, s.length() - 1,t.length()-1);
        System.out.println(ans);

        System.out.println(printLCS(s, t, s.length() - 1,t.length()-1));
    }

    public static int LCS(String s, String t, int index, int index2){
        if (index < 0 || index2 < 0){
            return 0; 
        }
    
        // If they match, move both back
        // Otherwise, explore other options : either one of the letters is in the substring 
        char c = s.charAt(index);
        char d = t.charAt(index2);
        if (c == d){
            int match = 1 + LCS(s, t, index-1, index2-1);
            return match;
        } else {
            int optionOne = LCS(s,t,index - 1, index2);
            int optionTwo = LCS(s,t,index,index2-1);
            return Math.max(optionOne,optionTwo);
        }
    }

    public static String printLCS(String s, String t, int index, int index2){
        if (index < 0 || index2 < 0){
            return "";
        }
    
        // If they match, move both back
        // Otherwise, explore other options : either one of the letters is in the substring 
        char c = s.charAt(index);
        char d = t.charAt(index2);
        if (c == d){
            return printLCS(s, t, index-1, index2-1) + c;
        } else {
            String one = printLCS(s,t,index - 1, index2);
            String two = printLCS(s,t,index,index2-1);

            return one.length() > two.length() ? one : two;
        }
    }
}
