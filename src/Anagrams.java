
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            char[] buf = strs[i].toCharArray();
            Arrays.sort(buf);
            String anagram = new String(buf);
            if (hashMap.containsKey(anagram)) {
                if (hashMap.get(anagram) == -1) {
                    list.add(strs[i]);
                } else {
                    list.add(strs[hashMap.get(anagram)]);
                    list.add(strs[i]);
                    hashMap.put(anagram, -1);
                }
            } else {
                hashMap.put(anagram, i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
