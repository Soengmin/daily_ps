package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a1937 {
    static int[][] bamboo;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            bamboo = new int[n][n];
            dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) bamboo[i][j] = Integer.parseInt(s[j]);
            }

            int answer = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) answer = Math.max(answer, move(i, j));
            System.out.println(answer);

            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int move(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx >= 0 && ty >= 0 && tx < bamboo.length && ty < bamboo[x].length && bamboo[x][y] < bamboo[tx][ty]) {
                cnt = Math.max(move(tx, ty) + 1, cnt);
                dp[x][y] = cnt;
            }
        }

        return cnt;
    }
}
