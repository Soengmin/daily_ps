package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class a16236 {
    public static class pos {
        int x;
        int y;
        int distance;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            int[][] sea = new int[N][N];
            int shark_x = 0, shark_y = 0;
            int shark_size = 2;

            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    sea[i][j] = Integer.parseInt(s[j]);
                    if (sea[i][j] == 9) {
                        shark_x = i;
                        shark_y = j;
                        sea[i][j] = 0;
                    }
                }
            }

            int time = 0;
            int eat_count = 0;

            while (true) {
                List<pos> list = get_possible_list(shark_size, sea, shark_x, shark_y);

                if (list.size() == 0) {
                    System.out.println(time);
                    break;
                } else {
                    time += list.get(0).distance;
                    shark_x = list.get(0).x;
                    shark_y = list.get(0).y;
                    sea[shark_x][shark_y] = 0;
                    if (++eat_count >= shark_size) {
                        shark_size++;
                        eat_count = 0;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<pos> get_possible_list(int shark_size, int[][] sea, int shark_x, int shark_y) {
        List<pos> list = new ArrayList<>();
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[i].length; j++) {
                if (sea[i][j] != 0 && sea[i][j] < shark_size) {
                    int distance = get_distance(i, j, sea, shark_size, shark_x, shark_y);
                    if (distance != -1) {
                        pos pos = new pos(i, j);
                        pos.distance = distance;
                        list.add(pos);
                    }
                }
            }
        }

        Collections.sort(list, new Comparator<pos>() {
            @Override
            public int compare(pos o1, pos o2) {
                if (o1.distance == o2.distance && o1.x == o2.x) return o1.y - o2.y;
                else if (o1.distance == o2.distance) return o1.x - o2.x;
                else return o1.distance - o2.distance;
            }
        });

        return list;
    }

    public static int get_distance(int target_x, int target_y, int[][] sea, int shark_size, int shark_x, int shark_y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<pos> q = new LinkedList<>();
        boolean[][] check = new boolean[sea.length][sea[0].length];
        int[][] cnt = new int[sea.length][sea[0].length];
        q.offer(new pos(shark_x, shark_y));
        check[shark_x][shark_y] = true;

        while (!q.isEmpty()) {
            pos poll = q.poll();

            if (poll.x == target_x && poll.y == target_y) return cnt[poll.x][poll.y];
            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < sea.length && y < sea.length && !check[x][y] && sea[x][y] <= shark_size) {
                    check[x][y] = true;
                    cnt[x][y] = cnt[poll.x][poll.y] + 1;
                    q.offer(new pos(x, y));
                }
            }
        }
        return -1;
    }
}
