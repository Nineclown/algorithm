import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B {

    static int T;
    static int N;
    static int ANSWER;
    static int map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Integer> area = new ArrayList<>();

        ANSWER = 0;
        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    area.add(bfs(i, j));
                }
            }
        }

        writer.write(area.size() + "\n");
        //System.out.println(area.size());
        area.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o1 - o2;
            }

        });


        for (Integer aa : area) {
            writer.write(aa + " ");
            //System.out.print(aa + " ");
        }

        reader.close();
        writer.close();


    }

    public static int bfs(int a, int b) {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        Queue<Integer> qq = new LinkedList<Integer>();

        qq.add(a);
        qq.add(b);
        map[a][b] = 0;
        int size = 1;

        while (!qq.isEmpty()) {
            int x = qq.remove();
            int y = qq.remove();

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;

                if (map[xx][yy] == 1) {
                    map[xx][yy] = 0;
                    qq.add(xx);
                    qq.add(yy);
                    size++;
                }
            }
        }

        return size;
    }

}