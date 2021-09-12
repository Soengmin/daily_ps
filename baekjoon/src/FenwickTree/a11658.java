package FenwickTree;

import java.io.*;
import java.util.StringTokenizer;

public class a11658 {
    static int[][] arr;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        tree = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                update(i, j, arr[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(x, y, value - arr[x][y]);
                arr[x][y] = value;
            } else if (query == 1) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int res = sum(x2, y2) - sum(x1 - 1, y2) - sum(x2, y1 - 1) + sum(x1 - 1, y1 - 1);
                bw.write(res + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static int sum(int x, int y) {
        int sum = 0;
        while (x > 0) {
            int ny = y;
            while (ny > 0) {
                sum += tree[x][ny];
                ny -= (ny & -ny);
            }
            x -= (x & -x);
        }
        return sum;
    }

    static void update(int x, int y, int diff) {
        while (x < tree.length) {
            int ny = y;
            while (ny < tree[0].length) {
                tree[x][ny] += diff;
                ny += (ny & -ny);
            }
            x += (x & -x);
        }
    }
}
