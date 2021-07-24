import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1865 {
    static class node {
        int node;
        int distance;

        public node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder answer = new StringBuilder();
            int testCase = Integer.parseInt(br.readLine());

            for (; testCase > 0; testCase--) {
                String[] s = br.readLine().split(" ");
                int loc = Integer.parseInt(s[0]);
                int load = Integer.parseInt(s[1]);
                int wormHole = Integer.parseInt(s[2]);

                List<List<node>> graph = new ArrayList<>();
                for (int i = 0; i <= loc; i++) graph.add(new ArrayList<>());
                for (int i = 0; i < load; i++) {
                    s = br.readLine().split(" ");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    int dist = Integer.parseInt(s[2]);
                    graph.get(a).add(new node(b, dist));
                    graph.get(b).add(new node(a, dist));
                }

                for (int i = 0; i < wormHole; i++) {
                    s = br.readLine().split(" ");
                    graph.get(Integer.parseInt(s[0])).add(new node(Integer.parseInt(s[1]),
                            Integer.parseInt(s[2]) * -1));
                }

                boolean check = false;
                for (int i = 1; i < graph.size(); i++) {
                    if (bellmanFord(graph, i)) {
                        answer.append("YES");
                        check = true;
                        break;
                    }
                }
                if (!check) answer.append("NO");
                if (testCase != 1) answer.append("\n");
            }

            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean bellmanFord(List<List<node>> graph, int start) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE - 1);
        dist[start] = 0;
        boolean update = false;

        for (int i = 1; i < graph.size(); i++) {
            update = false;

            for (int j = 1; j < graph.size(); j++) {
                for (node node : graph.get(j)) {
                    if (dist[j] != Integer.MAX_VALUE - 1 && dist[node.node] > dist[j] + node.distance) {
                        dist[node.node] = dist[j] + node.distance;
                        update = true;
                    }
                }
            }

            if (!update) break;
        }

        return update;
    }
}
