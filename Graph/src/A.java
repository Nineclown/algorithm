import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    /*
     * number: 1260
     * name: DFS 와 BFS
     * solution: PS, DFS, BFS
     * DFS 는 인접 리스트에서 정점을 하나씩 가져와서 더이상 가져올게 없을 때까지 쭉 호출하면서 재귀적으로 구현
     * BFS 는 인접 리스트에 들어있는 모든 정점을 한번에 큐에 넣어 놓고, 하나씩 빼면서 큐를 비울때까지 반복으로 구현.
     * */
    static int N, M, V;
    static ArrayList<Integer> Edges[];
    static boolean[] visited;
    static Queue<Integer> bfs_neighbor;

    public static void main(String[] args) throws IOException {
        int t1, t2, t3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        bfs_neighbor = new LinkedList<Integer>();


        for (int i = 0; i <= N; i++) {
            Edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            if (!Edges[t1].contains(t2)) {
                Edges[t1].add(t2);
                Edges[t2].add(t1);
            }
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(Edges[i]);
        }


        dfs(V);
        System.out.print("\n");

        Arrays.fill(visited, false);

        bfs(V);
        System.out.print("\n");

        reader.close();
    }

    static void dfs(int v) {
        if (visited[v])
            return;

        visited[v] = true;
        System.out.print(v + " ");
        for (int a : Edges[v]) {
            dfs(a);
        }
    }

    static void bfs(int v) {
        int tmp;
        if (visited[v])
            return;

        bfs_neighbor.offer(v);
        visited[v] = true;
        while (!bfs_neighbor.isEmpty()) {
            tmp = bfs_neighbor.poll();
            System.out.print(tmp + " ");
            for (int a : Edges[tmp]) {
                if (!visited[a]) {
                    bfs_neighbor.offer(a);
                    visited[a] = true;
                }
            }
        }

    }
}
