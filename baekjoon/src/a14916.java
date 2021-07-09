import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a14916 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while (n != 0) {
                if (n <= 1) {
                    System.out.println("-1");
                    System.exit(0);
                }
                if (n % 5 == 0) {
                    cnt += n / 5;
                    break;
                } else {
                    n -= 2;
                    cnt++;
                }
            }

            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
