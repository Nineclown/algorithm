import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class B {

    static int N, W;
    static ArrayList<String>[] Group;
    static String[][] Input;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Input = new String[N][N];
        visited = new int[N][N];

        int cnt = (int) Math.ceil(N / (double) 2);
        Group = new ArrayList[cnt];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                Input[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i <Group.length;i++) {
            Group[i] = new ArrayList<>();
            clockTurn(i, i, i);

        }

        for(String a: Group[0]) {
            System.out.println(a);
        }

    }

    public static void clockTurn(int num, int a, int b) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        Queue<Integer> qq = new LinkedList<Integer>();
        qq.add(a);
        qq.add(b);
        Group[num].add(Input[a][b]);
        visited[a][b] = 1;

        while (!qq.isEmpty()) {
            int x = qq.remove();
            int y = qq.remove();

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;

                if (visited[xx][yy] == 0) {
                    visited[xx][yy] = 1;
                    qq.add(xx);
                    qq.add(yy);
                    Group[num].add(Input[xx][yy]);
                    break;
                }
            }
        }
    }
}