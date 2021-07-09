import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2579 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            Integer[] dp = new Integer[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            dp[0] = 0;
            dp[1] = arr[1];
            if (n >= 2) dp[2] = arr[1] + arr[2];

            System.out.println(find(n, dp, arr));
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int find(int n, Integer[] dp, int[] arr) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2, dp, arr), find(n - 3, dp, arr) + arr[n - 1]) + arr[n];
        }

        return dp[n];
    }
}
