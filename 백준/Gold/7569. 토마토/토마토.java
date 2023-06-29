import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][][] arr;
    public static int n;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static boolean[][][] check;
    public static int m;
    public static int h;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        arr = new int[h][n][m];
        check = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }

        int answer = bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        answer = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                        check[i][j][k] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int z = node[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= n || nz >= m)
                    continue;

                if (arr[nx][ny][nz] == 0 && !check[nx][ny][nz]) {
                    check[nx][ny][nz] = true;
                    arr[nx][ny][nz] = arr[x][y][z] + 1;
                    queue.offer(new int[]{nx, ny, nz});
                }
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }

        return max - 1;
    }
}
