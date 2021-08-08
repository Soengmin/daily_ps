package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class a1766 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            indegree[Integer.parseInt(s[1])]++;
        }

        topologicalSort(indegree, graph);
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> graph) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        // 쉬운 문제 먼저 풀어야함, 번호가 낮을 수록 쉬운 문제

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            sb.append(cur).append(" ");

            for (Integer integer : graph.get(cur)) {
                indegree[integer]--;

                if (indegree[integer] == 0) q.offer(integer);
            }
        }
    }
}
