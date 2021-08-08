package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2357 {
    static class Node {
        int max;
        int min;

        public Node(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    static int[] arr;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        arr = new int[n];
        tree = new Node[n * 4];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        init(0, n - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            Node node = get_node(0, n - 1, 1, a - 1, b - 1);
            sb.append(node.min).append(" ").append(node.max).append("\n");
        }
        System.out.print(sb);
    }

    static Node init(int start, int end, int node) {
        if (start == end) return tree[node] = new Node(arr[start], arr[start]);
        int mid = (start + end) / 2;
        Node node1 = init(start, mid, node * 2);
        Node node2 = init(mid + 1, end, node * 2 + 1);
        return tree[node] = new Node(Math.max(node1.max, node2.max), Math.min(node1.min, node2.min));
    }

    static Node get_node(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return new Node(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1);
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        Node node1 = get_node(start, mid, node * 2, left, right);
        Node node2 = get_node(mid + 1, end, node * 2 + 1, left, right);
        return new Node(Math.max(node1.max, node2.max), Math.min(node1.min, node2.min));
    }
}
