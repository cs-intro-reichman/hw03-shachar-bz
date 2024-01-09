/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        String lowerWord = "";

        for(int i = 0; i < s.length(); i++){
            // turns a number into its ASCII representation
            char c = s.charAt(i);
            int x = (int) c ;
            
            // check if the current char is a capital letter
            if(x >= 65 && x <= 90){
                // turns the char to lower case
                x += 32;
            }

            c = (char) x;
            //add char to the new word
            lowerWord += c;
            

        }
        return lowerWord;
    }
}
