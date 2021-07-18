package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class a1916 {
    static class line implements Comparable<line> {
        int dest;
        int cost;

        public line(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(line o) {
            return cost - o.cost;
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int city = Integer.parseInt(br.readLine());
            int bus = Integer.parseInt(br.readLine());
            List<List<line>> graph = new ArrayList<>();

            for (int i = 0; i <= city; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < bus; i++) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int dest = Integer.parseInt(s[1]);
                int cost = Integer.parseInt(s[2]);

                graph.get(start).add(new line(dest, cost));
            }
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int destination = Integer.parseInt(s[1]);

            int[] cnt = new int[city + 1];
            Arrays.fill(cnt, Integer.MAX_VALUE);

            PriorityQueue<line> q = new PriorityQueue<>();
            q.offer(new line(start, 0));
            cnt[start] = 0;

            while(!q.isEmpty()) {
                line poll = q.poll();

                if (cnt[poll.dest] < poll.cost) {
                    continue;
                }

                for (line line : graph.get(poll.dest)) {
                    if (cnt[line.dest] > cnt[poll.dest] + line.cost) {
                        cnt[line.dest] = cnt[poll.dest] + line.cost;
                        q.offer(new line(line.dest, cnt[poll.dest] + line.cost));
                    }
                }
            }

            System.out.println(cnt[destination]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
