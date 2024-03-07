import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pisano = 1500000;
        int n = (int) (Long.parseLong(br.readLine()) % pisano);
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
            }
        }
        System.out.println(dp[n]);
    }
}