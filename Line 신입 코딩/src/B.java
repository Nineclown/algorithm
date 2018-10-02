import java.io.*;
import java.util.StringTokenizer;

public class B {

    static String[][] Matrix;
    static int[][] visited;
    static int N;
    static char prev;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(reader.readLine());
        Matrix = new String[N][N];
        visited = new int[N][N];
        prev = 'B';

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                Matrix[j][i] = st.nextToken();
            }
        }

        start(0, 0, 'B');

    }

    static void start(int n, int m, char prev) {
        int dx[] = {1, -1, 0, 0}; // R L F B
        int dy[] = {0, 0, -1, 1};
        int nn, mm;

        visited[n][m] = 1;
        char dir = Matrix[n][m].charAt(0);

        int wei = Matrix[n][m].charAt(1);

        if (prev == 'B') {
            if (dir == 'F') dir = 'B';
            else if (dir == 'B') dir = 'F';
            else if (dir == 'R') dir = 'L';
            else dir = 'R';
        }

        if (prev == 'R') {
            if (dir == 'F') dir = 'R';
            else if (dir == 'B') dir = 'L';
            else if (dir == 'R') dir = 'B';
            else dir = 'F';
        }

        if (prev == 'L') {
            if (dir == 'F') dir = 'L';
            else if (dir == 'B') dir = 'R';
            else if (dir == 'R') dir = 'F';
            else dir = 'B';
        }

        if (dir == 'F') {
            nn = n + dx[2];
            mm = n + wei * dy[2];
        } else if (dir == 'B') {
            nn = n + dx[3];
            mm = n + wei * dy[3];
        } else if (dir == 'R') {
            nn = n + wei * dx[0];
            mm = n + dy[0];
        } else {
            nn = n + wei * dx[1];
            mm = n + dy[1];
        }

        start(nn, mm, dir);


    }
}


}