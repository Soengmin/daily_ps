import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class a1167 {
    static int max = 0;
    static boolean[] check;
    static int end_node = 0;

    static class node {
        int n;
        int distance;

        public node(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<node>> graph = new ArrayList<>();
        try {
            int n = Integer.parseInt(br.readLine());
            check = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                for (int j = 1; j < s.length - 1; j += 2) {
                    graph.get(start).add(new node(Integer.parseInt(s[j]), Integer.parseInt(s[j + 1])));
                }
            }
            check[1] = true;
            dfs(graph, 1, 0);
            check[1] = false;
            check[end_node] = true;
            dfs(graph, end_node, 0);

            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(List<List<node>> graph, int depth, int distance) {
        if (distance > max) {
            max = distance;
            end_node = depth;
        }

        for (node node : graph.get(depth)) {
            if (!check[node.n]){
                check[node.n] = true;
                dfs(graph, node.n, distance + node.distance);
                check[node.n] = false;
            }
        }
    }
}
