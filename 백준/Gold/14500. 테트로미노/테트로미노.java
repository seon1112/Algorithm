

import java.util.Scanner;

public class Main{
    public static int[][][] tetromino = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // I 테트로미노
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // O 테트로미노
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // L 테트로미노
        {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
        {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // J 테트로미노
        {{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {1, -1}, {1, -2}}, // S 테트로미노
        {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
        {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // Z 테트로미노
        {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}
    };

    public static int[][] arr;
    public static int n;
    public static int m;
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < tetromino.length; k++) {
                    for (int r = 0; r < 4; r++) {
                        perm(i, j, k, r);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void perm(int x, int y, int type, int rotation) {
        int tot = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + rotate(tetromino[type][i][0], tetromino[type][i][1], rotation);
            int dy = y + rotate(tetromino[type][i][1], tetromino[type][i][0], rotation);
            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                return;
            }
            tot += arr[dx][dy];
        }
        answer = Math.max(answer, tot);
    }

    public static int rotate(int x, int y, int rotation) {
        if (rotation == 0) {
            return x;
        } else if (rotation == 1) {
            return -y;
        } else if (rotation == 2) {
            return -x;
        } else {
            return y;
        }
    }
}
