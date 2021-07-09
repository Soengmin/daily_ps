import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class a1107 {
    static int min;
    static int target;
    static int digit = 0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            target = Integer.parseInt(br.readLine());
            int bn = Integer.parseInt(br.readLine());

            List<Integer> num_list = new ArrayList<>();
            for (int i = 0; i < 10; i++) num_list.add(i);

            if (bn != 0) {
                String[] s = br.readLine().split(" ");
                for (int i = 0; i < s.length; i++) {
                    for (int j = 0; j < num_list.size(); j++) {
                        if (num_list.get(j) == Integer.parseInt(s[i])) {
                            num_list.remove(j);
                            break;
                        }
                    }
                }
            }

            for (int i = 1; target / i >= 1; i *= 10) digit++;
            min = Math.abs(target - 100);
            remote(0, num_list, 0);

            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void remote(int depth, List<Integer> list, int channel) {
        if (depth != 0 &&Math.abs(target - channel) + depth < min) {
            min = Math.abs(target - channel) + depth;
        }
        if (depth > digit) return;

        for (Integer integer : list) {
            remote(depth + 1, list, channel * 10 + integer);
        }
    }
}
