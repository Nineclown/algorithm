import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {
     /*
     * number: 11724
     * name: 연결 요소의 개수
     * solution: PS, DFS, BFS
     * 그래프가 주어지는데 모든 정점이 연결되지 않은 경우가 존재함. 이 경우엔 dfs, bfs 를 단순히 호출하는 경우엔
     * 모든 정점을 탐색하지 못함. 따라서 반복문을 돌려서 문제를 해결함.
     * 모든 정점을 반복해서 방문 안한 경우에 dfs 또는 bfs 를 호출하도록 구하고, 그때에 카운트를 올려서 총 부분 그래프의 개수를 구하면 됌.
     * */

    static boolean[] visited;
    static int N, M;
    static Queue<Integer> neighbor;
    static ArrayList<Integer>[] Adj;
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int t1, t2;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ANSWER = 0;
        Adj = new ArrayList[N + 1];
        neighbor = new LinkedList<>();

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            Adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(reader.readLine());
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            Adj[t1].add(t2);
            Adj[t2].add(t1);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                ANSWER++;
            }
        }

        writer.write(ANSWER + "\n");
        reader.close();
        writer.close();
    }

    static void bfs(int v) {
        int temp;
        if (visited[v])
            return;
        neighbor.offer(v);
        visited[v] = true;
        while (!neighbor.isEmpty()) {
            temp = neighbor.poll();
            for (int a : Adj[temp]) {
                if (!visited[a]) {
                    neighbor.offer(a);
                    visited[a] = true;
                }
            }
        }
    }

    static void dfs(int v) {
        if (visited[v])
            return;
        visited[v] = true;

        for (int a : Adj[v]) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }
}
