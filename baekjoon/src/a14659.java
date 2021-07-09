import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a14659 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
            String[] s = br.readLine().split(" ");
            int cur = 0;
            int cnt = 0;
            int answer = 0;
            for (String s1 : s) {
                int n = Integer.parseInt(s1);
                if (cur > n) cnt++;
                else {
                    answer = Math.max(cnt, answer);
                    cnt = 0;
                    cur = n;
                }
            }

            answer = Math.max(cnt, answer);
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
