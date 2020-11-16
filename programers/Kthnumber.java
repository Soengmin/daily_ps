package programers;
import java.util.*;

public class Kthnumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) a.add(array[j]);
            Collections.sort(a);
            answer[i] = a.get(commands[i][2] - 1);
            a.clear();
        }

        return answer;
    }

    public static void main(String []argv) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = solution(array, commands);
        System.out.println(Arrays.toString(answer));
    }
}
