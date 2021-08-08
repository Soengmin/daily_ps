package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1275 {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int turn = Integer.parseInt(s[1]);

        arr = new long[n];
        tree = new long[n * 4];

        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(s[i]);

        init(0, n - 1, 1);
        StringBuilder sb = new StringBuilder();
        for (; turn > 0; turn--) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int left = Math.min(a, b);
            long right = Math.max(a, b);
            int idx = Integer.parseInt(s[2]);
            long num = Long.parseLong(s[3]);
            long diff = num - arr[idx - 1];
            sb.append(sum(0, n - 1, 1, left - 1, right - 1)).append("\n");
            update(0, n - 1, 1, idx - 1, diff);
        }
        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static long sum(int start, int end, int node, int left, long right) {
        if (start > right || end < left) return 0;
        if (start >= left && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) return;
        tree[node] += diff;
        if (start == end) {
            arr[index] = tree[node];
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }
}
