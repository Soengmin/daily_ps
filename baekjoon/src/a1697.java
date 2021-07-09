import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class a1697 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int me = Integer.parseInt(s[0]);
            int sis = Integer.parseInt(s[1]);

            boolean[] check = new boolean[100001];
            int[] cnt = new int[100001];
            Queue<Integer> q = new LinkedList<>();

            q.offer(me);
            check[me] = true;

            while (!q.isEmpty()) {
                Integer cur = q.poll();
                if (cur == sis) {
                    System.out.println(cnt[sis]);
                    break;
                }

                if (cur + 1 < check.length && !check[cur + 1]) {
                    q.offer(cur + 1);
                    check[cur + 1] = true;
                    cnt[cur + 1] = cnt[cur] + 1;
                }
                if (cur - 1 >= 0 && !check[cur - 1]) {
                    q.offer(cur - 1);
                    check[cur - 1] = true;
                    cnt[cur - 1] = cnt[cur] + 1;
                }
                if (cur * 2 < check.length && !check[cur * 2]) {
                    q.offer(cur * 2);
                    check[cur * 2] = true;
                    cnt[cur * 2] = cnt[cur] + 1;
                }
                if (cur * -2 >= 0 && !check[cur * -2]) {
                    q.offer(cur * -2);
                    check[cur * -2] = true;
                    cnt[cur * - 2] = cnt[cur] + 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
