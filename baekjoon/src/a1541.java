import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1541 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int answer = 0;
            char pre = '+';
            boolean minus = false;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') sb.append(s.charAt(i));
                else {
                    if (!minus) {
                        answer += Integer.parseInt(sb.toString());
                    }
                    else {
                        answer -= Integer.parseInt(sb.toString());
                    }
                    if (s.charAt(i) == '-') minus = true;
                    sb = new StringBuilder();
                }
            }
            if (pre == '+' && !minus) answer += Integer.parseInt(sb.toString());
            else  answer -= Integer.parseInt(sb.toString());

            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
