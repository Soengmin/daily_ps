package SCC;

import java.io.*;
import java.util.*;

public class a2150 {
    static List<List<Integer>> graphA = new ArrayList<>();
    static List<List<Integer>> graphB = new ArrayList<>();
    static boolean[] visited;
    static List<List<Integer>> res = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        for (int i = 0; i <= v; i++) {
            graphA.add(new ArrayList<>());
            graphB.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graphA.get(a).add(b);
            graphB.get(b).add(a);
        }

        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) dfs(i);
        }

        Arrays.fill(visited, false);
        int num = 0;

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();

            if (visited[cur]) continue;

            redfs(cur, num);
            num++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num + "\n");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            Collections.sort(res.get(i));
            map.put(res.get(i).get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (Integer integer : res.get(value)) {
                sb.append(integer + " ");
            }
            sb.append("-1\n");
        });
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int n) {
        visited[n] = true;

        for (Integer integer : graphA.get(n)) {
            if (!visited[integer]) dfs(integer);
        }
        stack.push(n);
    }

    static void redfs(int n, int num) {
        visited[n] = true;
        res.get(num).add(n);

        for (Integer integer : graphB.get(n)) {
            if (!visited[integer]) redfs(integer, num);
        }
    }
}
