package io.zipcoder;
import java.util.logging.Logger;


/**
 * @author tariq
 */
public class StringsAndThings {

    private final static Logger logger = Logger.getLogger(StringsAndThings.class.getName());
    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        //Break string into array of words
        String[] str = input.split(" ");
        int count = 0;

        // Go through array
        // Does the word end in y or z
        // If so count++
        for (int i = 0; i < str.length; i++){
            String word = str[i];
            if (word.endsWith("y") || word.endsWith("z")){
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String str = base;
        str =  str.replace(remove, "");
        return str;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        String str = input;
        int countIS = 0;
        int countNOT = 0;


        // Check for 'is'
        for (int i = 0; i < str.length()-1; i++) {
            if ((str.charAt(i) == 'i') && (str.charAt(i + 1) == 's')) {
                countIS++;
            }
        }

        // Check for 'not'
        for (int j = 0; j < str.length()-2; j++) {
            if ((str.charAt(j) == 'n') && (str.charAt(j + 1) == 'o') && (str.charAt(j + 2) == 't')) {
                countNOT++;
            }
        }

        return countIS == countNOT;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    // Third test checks for true, documentation above states false. My interpretation of the doc is that 'xxggyygxx'
    // should be 'false' as the last 'g' does not have an adjacent 'g'.
    public Boolean gIsHappy(String input){
        String str = input;
        int numberOfG = 0;
        int happyGs = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i)== 'g') {
                numberOfG++;
            }
            if (str.charAt(i)== 'g' && (str.charAt(i-1) == 'g' || str.charAt(i+1) == 'g')) {
                happyGs++;
            }
        }

        return numberOfG == happyGs;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        String str = input;
        int tripleLetter = 0;

        for (int i = 0; i < str.length()-2; i++){
            char letter = str.charAt(i);
            if (str.charAt(i+1)== letter && str.charAt(i+2) == letter){
                tripleLetter++;
            }
        }

        return tripleLetter;
    }



}
