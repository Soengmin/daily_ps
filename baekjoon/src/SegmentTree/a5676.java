package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a5676 {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String tmp;
        StringBuilder sb = new StringBuilder();

        while ((tmp = br.readLine()) != null) {
            st = new StringTokenizer(tmp);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[n];
            tree = new int[n * 4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i] = (temp < 0) ? -1 : (temp > 0) ? 1 : 0;
            }

            init(0, n - 1, 1);
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                char commend = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (commend == 'C') {
                    b = (b < 0) ? -1 : (b > 0) ? 1 : 0;
                    update(0, n - 1, 1, a - 1, b);
                } else if (commend == 'P') {
                    int ret = multi(0, n - 1, 1, a - 1, b - 1);
                    if (ret < 0) sb.append("-");
                    else if (ret > 0) sb.append("+");
                    else sb.append("0");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int init(int start, int end, int node) {
        if (start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1);
    }

    static int multi(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 1;
        if (start >= left && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 - 1, left, right);
    }

    static int update(int start, int end, int node, int idx, int diff) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) {
            return tree[node] = diff;
        }
        int mid = (start + end) / 2;
        return update(start, mid, node * 2, idx, diff) * update(mid + 1, end, node * 2 - 1, idx, diff);
    }
}
