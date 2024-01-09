/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String unique = "";
        for(int i1 = 0; i1 < s.length(); i1++){
            boolean duplicate = false;
            char c = s.charAt(i1);
            int i2 = 0;
            while ( duplicate == false && i2 < unique.length()){
                if(unique.charAt(i2) == c && c != ' '){ 
                    duplicate = true;
                }
                i2++;
            }

            // add the char to the new string if he didnt show up already
            if(duplicate == false){
                unique += c;
            }
        }
        return unique;
    }
}
