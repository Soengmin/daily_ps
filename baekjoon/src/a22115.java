import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a22115 {
    static int answer = Integer.MAX_VALUE;
    static int dp[] = new int[100000];
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            int[] arr = new int[s.length];
            boolean[] check = new boolean[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            for (int i = 1; i <= n; i++) coffee(arr, check, 0, n, i, target);

            if (answer != Integer.MAX_VALUE) System.out.println(answer);
            else System.out.println("-1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void coffee(int[] caffeine, boolean[] check, int start, int n, int r, int target) {
        if (r == 0) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < check.length; i++) if (check[i]) {
                sum += caffeine[i];
                cnt++;
            }
            if (sum == target) {
                if (answer > cnt) answer = cnt;
            }
        }

        for (int i = start; i < caffeine.length; i++) {
            check[i] = true;
            coffee(caffeine, check, i + 1, n, r - 1, target);
            check[i] = false;
        }
    }
}