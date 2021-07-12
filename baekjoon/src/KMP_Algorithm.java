/**
 * https://coding-food-court.tistory.com/220
 */

public class KMP_Algorithm {
    public static void main(String[] args) {
        int[] a = makeTable("aabbccd");
    }

    public static int[] makeTable(String pattern) {
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;
        for (int i = 1; i < patterns.length; i++) {
            while (k > 0 && patterns[i] != patterns[k]) {
                k = table[k - 1];
            }
            if (patterns[i] == patterns[k]) table[i] = ++k;
        }

        return table;
    }

    public static void kmp(String parent, String pattern) {
        int[] table = makeTable(pattern);
        char[] parents = parent.toCharArray();
        char[] patterns = pattern.toCharArray();
        int k = 0;
        for (int i = 0; i < parents.length; i++) {
            while (k > 0 && parents[i] != patterns[k]) {
                k = table[k - 1];
            }
            if (parents[i] == patterns[k]) {
                if (k == patterns.length - 1) {
                    System.out.println((i - patterns.length + 2) + "번 째에 문자열 존재");
                    k = table[k];
                } else {
                    k++;
                }
            }
        }
    }
}
