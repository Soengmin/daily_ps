import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class a2606 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int computer = Integer.parseInt(br.readLine());
            int line = Integer.parseInt(br.readLine());
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= computer; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < line; i++) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean[] check = new boolean[computer + 1];
            System.out.println(count(1, graph, check) - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int count(int cur, List<List<Integer>> list, boolean[] check) {
        int cnt = 1;
        check[cur] = true;

        for (Integer integer : list.get(cur)) {
            if (!check[integer]) {
                cnt += count(integer, list, check);
            }
        }
        return cnt;
    }
}
