package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1197 {
    static int[] parent;
    static List<edge> edgeList = new ArrayList<>();

    static class edge {
        int start;
        int end;
        int dist;

        public edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int node = Integer.parseInt(s[0]);
            int line = Integer.parseInt(s[1]);

            parent = new int[node + 1];
            for (int i = 1; i <= node; i++) parent[i] = i;

            for (int i = 0; i < line; i++) {
                s = br.readLine().split(" ");
                edgeList.add(new edge(Integer.parseInt(s[0]),
                        Integer.parseInt(s[1]),
                        Integer.parseInt(s[2])));
            }
            Collections.sort(edgeList, (o1, o2) -> o1.dist - o2.dist);

            int answer = 0;
            for (int i = 0; i < edgeList.size(); i++) {
                edge edge = edgeList.get(i);
                if (find(edge.start) != find(edge.end)) {
                    answer += edge.dist;
                    union(edge.start, edge.end);
                }
            }

            System.out.print(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
