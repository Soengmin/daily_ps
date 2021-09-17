package SCC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class a1506 {
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> Rgraph = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] costs = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(s[i]);
            graph.add(new ArrayList<>());
            Rgraph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (s[j].charAt(0) == '1') {
                    graph.get(i).add(j);
                    Rgraph.get(j).add(i);
                }
            }
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i);
        }

        visited = new boolean[n];
        int num = 0;
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();

            if (visited[cur]) continue;

            Rdfs(cur, num);
            num++;
        }

        int answer = 0;

        for (List<Integer> re : res) {
            if (re.size() == 0) continue;
            int min = Integer.MAX_VALUE - 1;
            for (Integer cur : re) {
                if (min > costs[cur]) min = costs[cur];
            }
            answer += min;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void Rdfs(int n, int num) {
        visited[n] = true;
        res.get(num).add(n);

        for (Integer integer : Rgraph.get(n)) {
            if (!visited[integer]) Rdfs(integer, num);
        }
    }

    static void dfs(int n) {
        visited[n] = true;

        for (Integer integer : graph.get(n)) {
            if (!visited[integer]) dfs(integer);
        }
        stack.push(n);
    }
}
