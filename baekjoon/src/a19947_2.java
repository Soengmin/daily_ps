import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a19947_2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int money = Integer.parseInt(s[0]);
            int year = Integer.parseInt(s[1]);

            System.out.println((int)invest(money, year));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double invest(double money, int year) {
        if (year == 0) return money;
        if (year >= 5) {
            return Math.max(invest( Math.floor(money * 1.35), year - 5),
                    invest(Math.floor(money * 1.20), year - 3));
        } else if (year >= 3) {
            return Math.max(invest( Math.floor(money * 1.05), year - 1),
                    invest(Math.floor(money * 1.20), year - 3));
        }
        return invest(Math.floor(money * 1.05), year - 1);
    }
}
