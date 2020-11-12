package programers;

import java.util.*;

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        // participant : 참가자
        // completion : 완주자
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        for (; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) break;
        }
        String answer = participant[i];
        return answer;
    }
}