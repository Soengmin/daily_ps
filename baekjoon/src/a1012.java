import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1012 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCase = Integer.parseInt(br.readLine());

            for (int t = 0; t < testCase; t++) {
                String[] s = br.readLine().split(" ");
                int width = Integer.parseInt(s[0]);
                int height = Integer.parseInt(s[1]);
                int bc = Integer.parseInt(s[2]);
                boolean[][] board = new boolean[width][height];

                for (int i = 0; i < bc; i++) {
                    s = br.readLine().split(" ");
                    board[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
                }

                int cnt = 0;
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j]) cnt++;
                        dfs(board, i, j);
                    }
                }
                System.out.println(cnt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(boolean[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length) return;
        if (!board[x][y]) return;
        board[x][y] = false;
        dfs(board, x - 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
        dfs(board, x + 1, y);
    }
}
