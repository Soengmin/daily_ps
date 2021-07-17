package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a12100 {
    static int max = 0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }

            dfs(0, board);
            System.out.print(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (max < board[i][j]) max = board[i][j];
                }
            }
            return;
        }

        dfs(depth + 1, right(board));
        dfs(depth + 1, left(board));
        dfs(depth + 1, up(board));
        dfs(depth + 1, down(board));
    }

    public static int[][] left(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            tmp[i] = board[i].clone();
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length - 1; j++) {
                for (int k = j + 1; k < tmp[i].length; k++) {
                    if (tmp[i][k] == 0) continue;
                    else if (tmp[i][j] != 0 && tmp[i][k] == tmp[i][j]) {
                        tmp[i][j] = tmp[i][j] * 2;
                        tmp[i][k] = 0;
                        break;
                    } else if (tmp[i][j] == 0) {
                        tmp[i][j] = tmp[i][k];
                        tmp[i][k] = 0;
                        j--;
                        break;
                    } else break;
                }
            }
        }
        return tmp;
    }

    public static int[][] right(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            tmp[i] = board[i].clone();
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = tmp[i].length - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (tmp[i][k] == 0) continue;
                    else if (tmp[i][j] != 0 && tmp[i][k] == tmp[i][j]) {
                        tmp[i][j] = tmp[i][j] * 2;
                        tmp[i][k] = 0;
                        break;
                    } else if (tmp[i][j] == 0) {
                        tmp[i][j] = tmp[i][k];
                        tmp[i][k] = 0;
                        j++;
                        break;
                    } else break;
                }
            }
        }
        return tmp;
    }

    public static int[][] up(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            tmp[i] = board[i].clone();
        }
        for (int j = 0; j < tmp.length; j++) {
            for (int i = 0; i < tmp.length - 1; i++) {
                for (int k = i + 1; k < tmp.length; k++) {
                    if (tmp[k][j] == 0) continue;
                    else if (tmp[i][j] != 0 && tmp[k][j] == tmp[i][j]) {
                        tmp[i][j] = tmp[i][j] * 2;
                        tmp[k][j] = 0;
                        break;
                    } else if (tmp[i][j] == 0) {
                        tmp[i][j] = tmp[k][j];
                        tmp[k][j] = 0;
                        i--;
                        break;
                    } else break;
                }
            }
        }
        return tmp;
    }

    public static int[][] down(int[][] board) {
        int[][] tmp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            tmp[i] = board[i].clone();
        }
        for (int j = 0; j < tmp.length; j++) {
            for (int i = tmp.length - 1; i > 0; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    if (tmp[k][j] == 0) continue;
                    else if (tmp[i][j] != 0 && tmp[k][j] == tmp[i][j]) {
                        tmp[i][j] = tmp[i][j] * 2;
                        tmp[k][j] = 0;
                        break;
                    } else if (tmp[i][j] == 0) {
                        tmp[i][j] = tmp[k][j];
                        tmp[k][j] = 0;
                        i++;
                        break;
                    } else break;
                }
            }
        }
        return tmp;
    }
}
