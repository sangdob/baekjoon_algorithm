import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp 풀이 방식
 */
public class Main {
    static Integer[][] dp;
    static int[] w;
    static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        w = new int[n];
        v = new int[n];
        dp = new Integer[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(topdown(n - 1, k));
    }

    public static int topdown(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] == null) {
            if (w[i] > k) {
                dp[i][k] = topdown(i - 1, k);
            } else {
                dp[i][k] = Math.max(topdown(i - 1, k), topdown(i - 1, k - w[i]) + v[i]);
            }
        }
        return dp[i][k];
    }
}