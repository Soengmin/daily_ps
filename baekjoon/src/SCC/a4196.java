package SCC;

import java.io.*;
import java.util.*;

public class a4196 {
    static List<List<Integer>> graph;
    static List<List<Integer>> Rgraph;
    static List<List<Integer>> res;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;
    static int[] scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            scc = new int[n + 1];
            visited = new boolean[n + 1];

            graph = new ArrayList<>();
            Rgraph = new ArrayList<>();
            res = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                Rgraph.add(new ArrayList<>());
                res.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                graph.get(a).add(b);
                Rgraph.get(b).add(a);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            int num = 0;
            Arrays.fill(visited, false);
            while (!stack.isEmpty()) {
                Integer cur = stack.pop();

                if (visited[cur]) continue;
                Rdfs(cur, num);
                num++;
            }

            int[] inDegree = new int[num];
            for (int i = 1; i <= n; i++) {
                for (Integer node : graph.get(i)) {
                    if (scc[i] != scc[node]) inDegree[scc[node]]++;
                }
            }

            int answer = 0;
            for (int i = 0; i < num; i++) {
                if (inDegree[i] == 0) answer++;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void Rdfs(int n, int num) {
        visited[n] = true;
        res.get(num).add(n);
        scc[n] = num;
        for (Integer next : Rgraph.get(n)) {
            if(!visited[next]) Rdfs(next, num);
        }
    }

    static void dfs(int n) {
        visited[n] = true;
        for (Integer next : graph.get(n)) {
            if (!visited[next]) dfs(next);
        }
        stack.push(n);
    }
}
