package SCC;

import java.io.*;
import java.util.*;

public class a2207 {
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> SCC = new ArrayList<>();
    static int id = 0;
    static int[] parents;
    static boolean[] visited;
    static int[] scc;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[m * 2 + 2];
        visited = new boolean[m * 2 + 2];
        scc = new int[m * 2 + 2];

        for (int i = 0; i <= m * 2 + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > 0) a = trueX(a);
            else a = falseX(-a);
            if (b > 0) b = trueX(b);
            else b = falseX(-b);

            graph.get(notX(a)).add(b);
            graph.get(notX(b)).add(a);
        }

        for (int i = 2; i < graph.size(); i++) {
            if (parents[i] == 0) dfs(i);
        }

        boolean possible = true;
        for (int i = 1; i <= m; i++) {
            if (scc[trueX(i)] == scc[falseX(i)]) {
                possible = false;
                break;
            }
        }
        if (possible) bw.write("^_^");
        else bw.write("OTL");
        bw.flush();
        bw.close();
    }

    static int dfs(int n) {
        parents[n] = ++id;
        stack.push(n);
        int parent = parents[n];
        for (Integer next : graph.get(n)) {
            if (parents[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!visited[next]) parent = Math.min(parent, parents[next]);
        }

        if (parent == parents[n]) {
            List<Integer> list = new ArrayList<>();
            while (true) {
                Integer pop = stack.pop();
                list.add(pop);
                scc[pop] = parent;
                visited[pop] = true;
                if (pop == n) break;
            }
            SCC.add(list);
        }
        return parent;
    }

    static int trueX(int n) {
        return n << 1;
    }

    static int falseX(int n) {
        return n << 1 | 1;
    }

    static int notX(int n) {
        return n ^ 1;
    }
}
