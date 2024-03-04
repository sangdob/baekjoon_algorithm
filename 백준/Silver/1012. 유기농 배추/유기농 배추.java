import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int cnt;
    static int[][] dr = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            board = new int[n][m];
            cnt = 0;
            List<int[]> list = new LinkedList<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
                list.add(new int[]{x, y});
            }

            for (int[] pointer : list) {
                if (board[pointer[0]][pointer[1]] == 0) {
                    continue;
                }

                bfs(pointer, n, m);
            }
            System.out.println(cnt);
        }
        br.close();
    }

    public static void bfs(int[] point,int x,int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(point);
        board[point[0]][point[1]] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] move : dr) {
                int moveX = poll[0] + move[0];
                int moveY = poll[1] + move[1];

                if (moveX >= 0 && moveY >= 0 && moveX < x && moveY < y
                    && board[moveX][moveY] == 1) {
                    board[moveX][moveY] = 0;
                    q.offer(new int[]{moveX,moveY});
                }
            }
        }

        cnt++;
    }

}