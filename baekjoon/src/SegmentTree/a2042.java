package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2042 {
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[n * 4];
        init(0, arr.length - 1, 1);

        for (int i = 0; i < m + k; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            long c = Long.parseLong(s[2]);

            if (a == 1) {
                long diff = c - arr[b - 1];
                update(0, arr.length - 1, 1, b - 1, diff);
            } else if (a == 2) {
                sb.append(sum(0, arr.length - 1, 1, b - 1, c - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    // start, end : 원래 배열의 시작과 끝 인덱스
    static long init (int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        }
    }

    // left, right : 합을 구해야하는 범위 인덱스
    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) {
            // 범위 밖에 있는 경우
            return 0;
        }
        if (left <= start && end <= right) {
            // 범위 안에 속하는 경우
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    // index : 원래 배열에서 바꾸려는 자리
    // diff : 원래 값과 바꾸려는 값의 차이
    static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) {
            // 범위 밖에 있는 경우
            return;
        }
        tree[node] += diff; // 트리 값을 바꿈
        if (start == end) {
            // leaf 노드 인 경우
            arr[index] = tree[node];
            // diff 계산 할 때 arr값을 참고하기 때문에 arr의 값도 바꿔야함
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }
}
