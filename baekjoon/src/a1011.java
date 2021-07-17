import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1011 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (;testCase > 0; testCase--) {
                String[] s = br.readLine().split(" ");
                sb.append(move(Integer.parseInt(s[0]), Integer.parseInt(s[1]), 0, 0));
                if (testCase != 1) sb.append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int move(int start, int dest, int ms, int cnt) {
        int a = Integer.MAX_VALUE;
        if (dest - start == 1) return cnt + 1;
        if (start >= dest) return Integer.MAX_VALUE;

        int remain = dest - start;
        int tmp = 0;
        for (int i = 1; i <= ms + 1; i++) tmp += i;

        if (tmp <= remain) a = Math.min(a, move(start + ms + 1, dest, ms + 1, cnt + 1));
        else {
            a = Math.min(a, move(start + ms, dest, ms, cnt + 1));
            a = Math.min(a, move(start + ms - 1, dest, ms - 1, cnt + 1));
        }

        return a;
    }
}
