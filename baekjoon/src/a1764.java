import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1764 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            List<String> l1 = new ArrayList<>();
            List<String> l2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l1.add(br.readLine());
            }
            Collections.sort(l1);

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                String s1 = br.readLine();
                if (search(s1, l1)) {
                    cnt++;
                    l2.add(s1);
                }
            }
            Collections.sort(l2);

            System.out.println(cnt);
            for (String s1 : l2) {
                System.out.println(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean search(String target, List<String> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target.equals(list.get(mid))) return true;
            if (list.get(mid).compareTo(target) < 0) left = mid + 1;
            else right = mid;
        }
        if (list.get(right).equals(target)) return true;

        return false;
    }
}
