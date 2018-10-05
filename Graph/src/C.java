import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    /*
     * number: 1707
     * name: 이분 그래프
     * solution: PS, DFS, BFS
     *
     * 그래프가 주어지는데, 얘를 하나의 선으로 갈랐을 때, 갈라진 영역 내에선 서로 연결 된 정점이 없어야 한다. 이렇게 가를 수 있는지 없는지를 묻는 문제
     * 방법은 하나하나 다 탐색을 하는데 탐색을 할 때마다 다른 색으로 정점을 칠함.
     * 만약 두 개로 가를 수 있을 경우엔, 임의의 두 정점이 서로 같은 색일 경우가 없다.
     * 따라서 dfs 에서 탐색을 하다가 이미 방문한 정점이면서 동시에 현재 정점과 색이 같은 이웃 정점을 찾으면 이건 NO를 출력하면 된다.
     *
     * 여기서 구현한 코드의 포인트는 재귀함수를 어떻게 종료시키는 가 이다. 내가 원하는 방향으로 종료시키기 위해서 모든 분기문에서 리턴값을 설정해준다.
     *
     * */

    static int TC;
    static int N, M;
    static ArrayList<Integer>[] Edges;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        int t1, t2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        TC = Integer.parseInt(reader.readLine());

        while (TC-- > 0) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());

            Edges = new ArrayList[N + 1];
            visited = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                Edges[i] = new ArrayList<>();
            }

            for (int i = 1; i <= M; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                t1 = Integer.parseInt(stringTokenizer.nextToken());
                t2 = Integer.parseInt(stringTokenizer.nextToken());

                Edges[t1].add(t2);
                Edges[t2].add(t1);
            }

            boolean Ok = true;

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    if (!dfs(i, 1))
                        Ok = false;
                }
            }

            System.out.println(Ok? "YES" : "NO");

        }

        reader.close();
    }

    static boolean dfs(int v, int c) {
        visited[v] = c;
        for (int a : Edges[v]) {
            if (visited[a] == 0) {
                if (!dfs(a, 3 - c))
                    return false;
            } else if (visited[a] == visited[v]) {
                return false;
            }
        }
        return true;
    }
}
