
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesSum {

    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>();
        double[][] dp = new double[6 * n + 1][n + 1];
        for (int i = 1; i <= 6; i++) dp[i][1] = 1.0 / 6.0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                dp[j][i] = 0.0;
                for (int k = 1; k < Math.min(j, 7); k++) {
                    dp[j][i] += dp[j - k][i - 1];
                }
                dp[j][i] /= 6.0;
            }
        }
        for (int i = n; i <= n * 6; i++) {
            list.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[i][n]));
        }
        return list;
    }

    public static void main(String[] args) {

    }
}