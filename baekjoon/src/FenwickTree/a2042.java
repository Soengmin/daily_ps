package FenwickTree;

import java.io.*;
import java.util.StringTokenizer;

public class a2042 {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (query == 1) {
                long b = Long.parseLong(st.nextToken());
                update(a, b - arr[a]);
                arr[a] = b;
            } else if (query == 2) {
                int b = Integer.parseInt(st.nextToken());
                bw.write((sum(b) - sum(a - 1)) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static long sum(int idx) {
        long sum = 0;
        int tmp = idx;

        while (tmp > 0) {
            sum += tree[tmp];
            tmp = tmp - (tmp & -tmp);
        }

        return sum;
    }

    static void update(int idx, long value) {
        int tmp = idx;
        while (tmp < arr.length) {
            tree[tmp] += value;
            tmp = tmp + (tmp & -tmp);
        }
    }
}
