import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a10709 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int[][] sky = new int[x][y];
            for (int i = 0; i < x; i++) {
                int c = -1;
                String s1 = br.readLine();
                for (int j = 0; j < s1.length(); j++) {
                    char cur = s1.charAt(j);
                    if (cur == 'c') {
                        c = 0;
                        sky[i][j] = 0;
                    } else if (cur == '.') {
                        if (c >= 0) {
                            sky[i][j] = ++c;
                        } else if (c < 0) {
                            sky[i][j] = -1;
                        }
                    }
                }
            }

            for (int[] ints : sky) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
