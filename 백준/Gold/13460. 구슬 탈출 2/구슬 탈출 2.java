import java.io.*;
import java.util.*;

class Node {
    int rx, ry, bx, by, cnt;
    Node(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}
public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][][] visit;
    static Node r, b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R')
                    r = new Node(i, j, 0, 0, 0);
                else if(map[i][j] == 'B')
                    b = new Node(0, 0, i, j, 0);
            }
        }

        System.out.println(check());
    }

    public static int check() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r.rx, r.ry, b.bx, b.by, 1));
        visit[r.rx][r.ry][b.bx][b.by] = true;
        while(!q.isEmpty()) {
        	Node temp = q.poll();
            int rx = temp.rx;
            int ry = temp.ry;
            int bx = temp.bx;
            int by = temp.by;
            int count = temp.cnt;
            if(count > 10) {
                return -1;
            }
            for(int i = 0; i < 4; i++) {
                int rnx = rx;
                int rny = ry;
                int bnx = bx;
                int bny = by;

                boolean Rcheck = false;
                boolean Bcheck = false;

                while(map[rnx + dx[i]][rny + dy[i]] != '#') {
                    rnx += dx[i];
                    rny += dy[i];
                    if(map[rnx][rny] == 'O') {
                    	Rcheck = true;
                        break;
                    }
                }

                while(map[bnx + dx[i]][bny + dy[i]] != '#') {
                    bnx += dx[i];
                    bny += dy[i];
                    if(map[bnx][bny] == 'O') {
                    	Bcheck = true;
                        break;
                    }
                }

                if(Bcheck) continue;
                if(Rcheck) return count;

                if(rnx == bnx && rny == bny) {
                    if(i == 0) {
                        if(rx < bx) bnx++;
                        else rnx++;
                    }
                    else if(i == 1) {
                        if(rx < bx) rnx--;
                        else bnx--;
                    }
                    else if(i == 2) {
                        if(ry < by) bny++;
                        else rny++;
                    }
                    else {
                        if(ry < by) rny--;
                        else bny--;
                    }
                }

                if(!visit[rnx][rny][bnx][bny]) {
                    q.add(new Node(rnx, rny, bnx, bny, count + 1));
                    visit[rnx][rny][bnx][bny] = true;
                }
            }
        }
        return -1;
    }
}