
class WordDictionary {

    public class Trie {
        public boolean exist;
        public Trie[] p;
        public Trie() {
            this.exist = false;
            p = new Trie[26];
        }
    }

    private Trie root = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        int len = word.length();
        Trie cur = root;
        for (int i = 0; i < len; i++) {
            if (cur.p[word.charAt(i) - 'a'] == null) {
                cur.p[word.charAt(i) - 'a'] = new Trie();
            }
            cur = cur.p[word.charAt(i) - 'a'];
        }
        cur.exist = true;
    }

    public boolean help(Trie root, String word) {
        int len = word.length();
        Trie cur = root;
        int idx = len;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (c == '.') {
                idx = i;
                break;
            } else {
                cur = cur.p[c - 'a'];
                if (cur == null) {
                    return false;
                }
            }
        }
        if (idx == len) {
            return cur.exist;
        } else {
            String sub = word.substring(idx + 1);
            for (char c = 'a'; c <= 'z'; c++) {
                if (cur.p[c - 'a'] != null && help(cur.p[c - 'a'], sub)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return help(root, word);
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

public class AddAndSearchWord {
    public static void main(String[] args) {

    }
}