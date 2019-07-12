
import java.util.ArrayList;

public class SimplifyPath {

    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        int lastIdx = 1;
        int idx;
        ArrayList<String> arrayList = new ArrayList<String>();
        while ((idx = path.indexOf("/", lastIdx)) != -1) {
            String temp = path.substring(lastIdx, idx);
            if (temp.equals("..")) {
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if (!temp.equals(".") && !temp.equals("")) {
                arrayList.add(path.substring(lastIdx, idx));
            }
            lastIdx = idx + 1;
        }
        if (lastIdx < path.length()) {
            String temp = path.substring(lastIdx);
            if (temp.equals("..")) {
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if (!temp.equals(".") && !temp.equals("")) {
                arrayList.add(path.substring(lastIdx));
            }
        }
        String res = new String("");
        for (int i = 0; i < arrayList.size(); i++) {
            res += "/" + arrayList.get(i);
        }
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {

    }
}

