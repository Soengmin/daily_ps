package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1103 {
    static int max = 0;
    static int[][] dp;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int[][] board = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            boolean[][] check = new boolean[board.length][board[0].length];
            dp = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < board[i].length; j++) board[i][j] = tmp.charAt(j) - '0';
            }
            dfs(0, 0, board, check, 0);
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int x, int y, int[][] board, boolean[][] check, int cnt) {
        if (max < cnt) max = cnt;
        if (board[x][y] == 24) return;
        dp[x][y] = cnt;

        if (x + board[x][y] < board.length && dp[x + board[x][y]][y] <= cnt) {
            if (check[x + board[x][y]][y]) {
                System.out.println("-1");
                System.exit(0);
            }
            check[x + board[x][y]][y] = true;
            dfs(x + board[x][y], y, board, check, cnt + 1);
            check[x + board[x][y]][y] = false;
        } else if (max < cnt + 1) max = cnt + 1;
        if (x - board[x][y] >= 0 && dp[x - board[x][y]][y] <= cnt) {
            if (check[x - board[x][y]][y]) {
                System.out.println("-1");
                System.exit(0);
            }
            check[x - board[x][y]][y] = true;
            dfs(x - board[x][y], y, board, check, cnt + 1);
            check[x - board[x][y]][y] = false;
        } else if (max < cnt + 1) max = cnt + 1;
        if (y + board[x][y] < board[x].length && dp[x][y + board[x][y]] <= cnt) {
            if (check[x][y + board[x][y]]) {
                System.out.println("-1");
                System.exit(0);
            }
            check[x][y + board[x][y]] = true;
            dfs(x, y + board[x][y], board, check, cnt + 1);
            check[x][y + board[x][y]] = false;
        } else if (max < cnt + 1) max = cnt + 1;
        if (y - board[x][y] >= 0 && dp[x][y - board[x][y]] <= cnt) {
            if (check[x][y - board[x][y]]) {
                System.out.println("-1");
                System.exit(0);
            }
            check[x][y - board[x][y]] = true;
            dfs(x, y - board[x][y], board, check, cnt + 1);
            check[x][y - board[x][y]] = false;
        } else if (max < cnt + 1) max = cnt + 1;
    }
}
