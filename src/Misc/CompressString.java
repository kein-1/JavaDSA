package Misc;

// Received this in an OA on Hackerrank:

// Given a string s, decompress it so it is alphabetically sorted followed by the count
// i.e a13b56a12c15b2 will become a25b58c15
// Guaranteed it will be lower case letters

public class CompressString {
    public static void main(String[] args) {
        String s = "a13b56a12c15b2";
        

        // Thinking we keep track of the curr value character. When we encounter a new character, we update the count for the
        // current character, then reset the count and set prev to this character
        // We can use an array of size 26 to keep track since we only deal with lower case letters

        int[] arr = new int[26];
        
        int count = 0;
        // Set curr char to first letter 
        char curr = s.charAt(0);
        for (int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            // If it is digit, update the count
            // c-'0' converts char 0-9 to ints in ascii. then - '0' will reuslt in the corresponding int vlaue  
            if (Character.isDigit(c)){
                count = count * 10 + (c - '0');
            } else {
                // We encountered another char, so update our current char's value and set this new char to our current
                // Reset the count  
                arr[curr-'a'] += count;
                count =  0;
                curr = c;
            }
        }
        // Last val in string will be a digit, so we need to account for this 
        arr[curr-'a'] += count;

        // Use string builder to build new answer 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++){
            if (arr[i] > 0){
                sb.append((char) (i+'a'));
                sb.append(arr[i]);
            }    
        }

        System.out.println(s);
        System.out.println(sb.toString());

    

    }



}
