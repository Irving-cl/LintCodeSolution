
public class SortColors2 {

    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else {
                    colors[num - 1]--;
                    colors[i] = 0;
                }
            }
        }
        int idx = colors.length - 1;
        for (int i = k; i >= 1; i--) {
            int cnt = -colors[i - 1];
            for (int j = 0; j < cnt; j++) {
                colors[idx--] = i;
            }
        }
    }

    public static void main(String[] args) {

    }
}

