import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class a1676 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            BigInteger fac = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
                fac = fac.multiply(new BigInteger(String.valueOf(i)));
            }
            String s = fac.toString();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '0') {
                    System.out.println(s.length() - i - 1);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
