import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a9020 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int t = Integer.parseInt(br.readLine());
                int[] board = new int[t + 1];
                for (int a = 1; a <= t; a++) board[a] = a;
                board[1] = 0;
                for (int j = 2; j <= Math.sqrt(board.length); j++) {
                    if (board[j] == 0) continue;
                    for (int k = j; k <= t; k += j) {
                        if (j == k) continue;
                        board[k] = 0;
                    }
                }
                int min = Integer.MAX_VALUE;
                int x = 0;
                int y = 0;
                for (int p = 0; p < board.length; p++) {
                    for (int q = p; q < board.length; q++) {
                        if (board[p] + board[q] == t) {
                            if (min > Math.abs(p - q)) {
                                x = p;
                                y = q;
                                min = Math.abs(p - q);
                            }
                        }
                    }
                }
                sb.append(board[x] + " " + board[y] + "\n");

            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
