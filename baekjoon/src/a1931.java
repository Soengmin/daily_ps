import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class a1931 {
    static class meeting{
        int start;
        int end;

        public meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            meeting[] meetings = new meeting[n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                meetings[i] = new meeting(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            }

            Arrays.sort(meetings, new Comparator<meeting>() {
                @Override
                public int compare(meeting o1, meeting o2) {
                    if (o1.end == o2.end) return o1.start - o2.start;
                    return o1.end - o2.end;
                }
            });

            int end_time = 0;
            int cnt = 0;
            for (meeting meeting : meetings) {
                if (meeting.start >= end_time) {
                    end_time = meeting.end;
                    cnt++;
                }
            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
