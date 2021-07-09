import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a1389 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] s = br.readLine().split(" ");
            int userN = Integer.parseInt(s[0]);
            int lineN = Integer.parseInt(s[1]);

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= userN; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < lineN; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int[] user;
            int answer = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= userN; i++) {
                int sum = 0;
                for (int j = 1; j <= userN; j++) {
                    if (i == j) continue;
                    user = new int[userN + 1];
                    sum += kevin(i, j, user, graph);
                }
                if (min > sum) {
                    answer = i;
                    min = sum;
                }
            }
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int kevin(int start, int destination, int[] user, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            List<Integer> list = graph.get(cur);

            if (cur == destination) return user[cur];
            for (Integer integer : list) {
                if (user[integer] == 0) {
                    q.offer(integer);
                    user[integer] = user[cur] + 1;
                }
            }
        }

        return 0;
    }
}
