package programers;
import java.util.*;

class Solution {
    static int score(int pattern[],int answers[]) {
        int a = 0; // 맞춘 문제 개수
        for (int i = 0; i < answers.length; i++) if (pattern[i % pattern.length] == answers[i]) a++;
        return a;
    }

    public int[] solution(int[] answers) {
        int a[];
        int b[] = new int[3];
        int patter[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int c[] = {score(patter[0],answers), score(patter[1],answers), score(patter[2],answers) };
        Arrays.sort(c);
        int i = 0;
        if (c[2] == score(patter[0],answers)) b[i++] = 1;
        if (c[2] == score(patter[1],answers)) b[i++] = 2;
        if (c[2] == score(patter[2],answers)) b[i++] = 3;
        for (i = 0; i < b.length; i++) if (b[i] == 0) break;
        a = new int[i];
        for (i = 0; i < a.length; i++) a[i] = b[i];
        return a;
    }



}