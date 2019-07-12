
public class GasStation {

    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tot = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            tot += gas[i] - cost[i];
        }
        if (tot < 0) {
            return -1;
        }
        int start = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}

