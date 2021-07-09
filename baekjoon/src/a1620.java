import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class a1620 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int dic = Integer.parseInt(s[0]);
            int pro = Integer.parseInt(s[1]);

            HashMap<Integer, String> pocketmon = new HashMap<>();
            HashMap<String, Integer> pock = new HashMap<>();
            for (int i = 0; i < dic; i++) {
                String s1 = br.readLine();
                pocketmon.put(i + 1, s1);
                pock.put(s1, i + 1);
            }

            for (int i = 0; i < pro; i++) {
                String query = br.readLine();
                if (query.charAt(0) >= '0' && query.charAt(0) <= '9') {
                    System.out.println(pocketmon.get(Integer.parseInt(query)));
                } else {
                    System.out.println(pock.get(query));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
