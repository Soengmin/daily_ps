import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class a2075 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (String s1 : s) {
                    q.offer(Integer.parseInt(s1));
                }
            }

            for (int i = 0; i < n - 1; i++) q.poll();
            System.out.println(q.poll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
