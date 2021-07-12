import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a16171 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String board = br.readLine();
            String target = br.readLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length(); i++) if (board.charAt(i) < '0' || board.charAt(i) > '9')
                sb.append(board.charAt(i));
            char[] st = sb.toString().toCharArray();
            int[] table = makeTable(target);
            char[] tarArr = target.toCharArray();
            int k = 0;
            for (int i = 0; i < st.length; i++) {
                while (k > 0 && st[i] != tarArr[k]) {
                    k = table[k - 1];
                }
                if (st[i] == tarArr[k]) {
                    if (k == tarArr.length - 1) {
                        System.out.println("1");
                        System.exit(0);
                    } else {
                        k++;
                    }
                }
            }

            System.out.println("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] makeTable(String pattern) {
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;
        for (int i = 1; i < patterns.length; i++) {
            while (k > 0 && patterns[i] != patterns[k]) {
                k = table[k - 1];
            }
            if (patterns[i] == patterns[k]) table[i] = ++k;
        }

        return table;
    }
}
