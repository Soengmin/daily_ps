package programers;

import java.util.Arrays;

public class chae6bok {
    public static int solution(int n, int[] lost, int[] reserve) {
        // lost : 도난당한 학생 번호 n : 전체 학생수
        // reserve : 여벌옷 가져온 학생 번호
        int[] a = new int[n];
        Arrays.fill(a,1);
        for (int i = 0; i < reserve.length; i++) a[reserve[i]-1]++;
        for (int i = 0; i < lost.length; i++) a[lost[i]-1]--;
        for (int i = 0; i < n; i++) {
            if (a[i]>=2) {
                if (i>0 && a[i-1] == 0) {
                    a[i]--;
                    a[i-1]++;
                }
                else if(i < n-1 && a[i+1] == 0) {
                    a[i]--;
                    a[i+1]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) if(a[i] >= 1) answer++;
        return answer;
    }

    public static void main(String[] argv) {
        int a[] = {2,4};
        int b[] = {1,3,5};
        System.out.println(solution(5,a,b));
    }
}
