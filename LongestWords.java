
import java.util.ArrayList;

public class LongestWords {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> list = new ArrayList<String>();
        int len = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > len) {
                list.clear();
                list.add(dictionary[i]);
                len = dictionary[i].length();
            } else if (dictionary[i].length() == len) {
                list.add(dictionary[i]);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        
    }
}
