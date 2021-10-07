package flow;

import java.io.*;
import java.util.*;

public class a2188 {
    static class Edge {
        int node, flow, capacity;
        Edge revEdge;

        public Edge(int node, int flow, int capacity) {
            this.node = node;
            this.flow = flow;
            this.capacity = capacity;
        }

        int spare() {
            return capacity - flow;
        }

        void addFlow(int n) {
            flow += n;
            revEdge.flow -= n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= 401; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= 200; i++) {
            Edge cow = new Edge(i, 0, 1);
            Edge start = new Edge(0, 0, 0);
            cow.revEdge = start;
            start.revEdge = cow;
            graph.get(0).add(cow);
            graph.get(i).add(start);

            Edge house = new Edge(i + 200, 0, 0);
            Edge end = new Edge(401, 0, 1);
            house.revEdge = end;
            end.revEdge = house;
            graph.get(i + 200).add(end);
            graph.get(401).add(house);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            while (k-- > 0) {
                int h = Integer.parseInt(st.nextToken()) + 200;
                Edge cow = new Edge(i, 0, 0);
                Edge house = new Edge(h, 0, 1);
                cow.revEdge = house;
                house.revEdge = cow;
                graph.get(i).add(house);
                graph.get(h).add(cow);
            }
        }

        int start = 0;
        int dest = 401;
        int[] parent = new int[402];
        int answer = 0;
        while (true) {
            Queue<Integer> q = new LinkedList<>();
            Arrays.fill(parent, -1);
            Edge[] Path = new Edge[402];
            q.offer(start);

            while (!q.isEmpty() && parent[dest] == -1) {
                Integer cur = q.poll();

                for (Edge next : graph.get(cur)) {
                    if (next.spare() > 0 && parent[next.node] == -1) {
                        parent[next.node] = cur;
                        q.offer(next.node);
                        Path[next.node] = next;
                        if (next.node == dest) break;
                    }
                }
            }

            if (parent[dest] == -1) break;

            int amount = Integer.MIN_VALUE;
            for (int i = dest; i != start; i = parent[i]) {
                amount = Math.max(amount, Path[i].spare());
            }

            for (int i = dest; i != start; i = parent[i]) {
                Path[i].addFlow(amount);
            }
            answer += amount;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
