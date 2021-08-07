import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1208 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);
        arr = new int[n];

        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        dfs(-1, n / 2, 0, aList);
        dfs(n / 2 - 1, n, 0, bList);

        Collections.sort(aList);
        Collections.sort(bList);

        long cnt = 0;

        int pointerL = 0;
        int pointerR = bList.size() - 1;

        while (true) {
            if (pointerL == aList.size() || pointerR < 0) break;
            int lv = aList.get(pointerL);
            int rv = bList.get(pointerR);

            if (lv + rv == target) {
                long lc = 0;
                while (pointerL < aList.size() && aList.get(pointerL) == lv) {
                    lc++;
                    pointerL++;
                }
                long rc = 0;
                while (pointerR >= 0 && bList.get(pointerR) == rv) {
                    rc++;
                    pointerR--;
                }
                cnt += lc * rc;
            }

            if (lv + rv > target) pointerR--;
            if (lv + rv < target) pointerL++;
        }

        if (target == 0) System.out.println(cnt - 1);
        else System.out.println(cnt);
    }

    public static void dfs(int idx, int end, int sum, List<Integer> list) {
        list.add(sum);
        for (int i = idx + 1; i < end; i++) {
            dfs(i,end, sum + arr[i], list);
        }
    }
}
