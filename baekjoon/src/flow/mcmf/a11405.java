package flow.mcmf;

import java.io.*;
import java.util.*;

public class a11405 {
    static int[][] flow, capacity, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        flow = new int[202][202];
        capacity = new int[202][202];
        cost = new int[202][202];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 203; i++) graph.add(new ArrayList<>());

        int start = 0;
        int dest = 201;

        st = new StringTokenizer(br.readLine());
        for (int i = 101; i < 101 + n; i++) {
            capacity[i][dest] = Integer.parseInt(st.nextToken());
            graph.get(dest).add(i);
            graph.get(i).add(dest);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            capacity[start][i] = Integer.parseInt(st.nextToken());
            graph.get(start).add(i);
            graph.get(i).add(start);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 101; j < 101 + n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                cost[j][i] = -cost[i][j];
                capacity[i][j] = 100000000;
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }

        int answer = 0;
        int[] parent = new int[202];
        int[] dist = new int[202];
        while (true) {
            boolean[] inQ = new boolean[202];
            Queue<Integer> q = new LinkedList<>();
            Arrays.fill(parent, -1);
            Arrays.fill(dist, Integer.MAX_VALUE);

            q.offer(start);
            inQ[start] = true;
            dist[start] = 0;

            while(!q.isEmpty()) {
                Integer cur = q.poll();
                inQ[cur] = false;
                for (Integer next : graph.get(cur)) {
                    if (capacity[cur][next] - flow[cur][next] > 0 && dist[next] > dist[cur] + cost[cur][next]) {
                        dist[next] = dist[cur] + cost[cur][next];
                        parent[next] = cur;
                        if (!inQ[next]) {
                            inQ[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }

            if (parent[dest] == -1) break;

            int amount = Integer.MAX_VALUE;
            for (int i = dest; i != start; i = parent[i])
                amount = Math.min(amount, capacity[parent[i]][i] - flow[parent[i]][i]);

            for (int i = dest; i != start; i = parent[i]) {
                answer += amount * cost[parent[i]][i];
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
