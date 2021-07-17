package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a10026 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            char[][] board = new char[n][n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) board[i][j] = s.charAt(j);
            }

            int regular = 0;
            int rg = 0;

            boolean[][] visit = new boolean[n][n];
            boolean[][] visit2 = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        dfs(board, i, j, visit, board[i][j], true);
                        rg++;
                    }
                    if (!visit2[i][j]) {
                        dfs(board, i, j, visit2, board[i][j], false);
                        regular++;
                    }
                }
            }

            System.out.println(regular + " " + rg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(char[][] board, int x, int y, boolean[][] visit, char find, boolean mode) {
        if (mode) {
            if ((find == 'R' || find == 'G') && board[x][y] == 'B') return;
            else if (find == 'B' && board[x][y] != 'B') return;
        } else {
            if (find != board[x][y]) return;
        }
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && ty >= 0 && tx < board.length && ty < board.length && !visit[tx][ty]) {
                dfs(board, tx, ty, visit, find, mode);
            }
        }
    }
}
