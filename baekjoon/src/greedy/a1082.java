package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1082 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] numbers = new int[n];

            int min_price = Integer.MAX_VALUE;
            int min_price_idx = 0;
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(s[i]);
                if (numbers[i] <= min_price) {
                    min_price = numbers[i];
                    min_price_idx = i;
                }
            }
            int Money = Integer.parseInt(br.readLine());
            int first_money = Money;
            StringBuilder sb = new StringBuilder();
            int max_digit;

            Boolean first_zero = false;
            if (min_price_idx == 0) {
                first_zero = true;
                int min = Integer.MAX_VALUE;
                for (int i = 1; i < n; i++)
                    if (numbers[i] <= min) {
                        min = numbers[i];
                    }
                max_digit = (Money - min) / numbers[min_price_idx];
            } else max_digit = Money / numbers[min_price_idx] - 1;
            Money -= numbers[min_price_idx] * (Money / numbers[min_price_idx]);

            while (true && n > 1) {
                Boolean status = true;
                if (!first_zero) {
                    for (int i = n - 1; i > min_price_idx; i--) {
                        if (Money + numbers[min_price_idx] >= numbers[i]) {
                            sb.append(i);
                            Money -= numbers[i] - numbers[min_price_idx];
                            status = false;
                            break;
                        }
                    }
                } else {
                    for (int i = n - 1; i > min_price_idx; i--) {
                        if (Money + numbers[min_price_idx] >= numbers[i]) {
                            sb.append(i);
                            Money -= numbers[i] - numbers[min_price_idx];
                            first_zero = false;
                            status = false;
                            break;
                        }
                    }
                    if (first_zero) {
                        Money += numbers[min_price_idx];
                        status = false;
                        if (Money >= first_money) status = true;
                    }
                }
                if (status) break;
            }
            for (int i = sb.length(); i <= max_digit; i++) sb.append(min_price_idx);

            if (n == 1 || sb.length() == 0) System.out.println("0");
            else
                System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
