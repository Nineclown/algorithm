import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class C_2 {
    /*
     * number: 1707
     * name: 이분 그래프
     * solution: PS, DFS, BFS
     *
     * 삼성 SDS 에서 BFS로 푼 방식.
     * 접근 방식은 동일하다. 인접한 정점들과 현재 정점의 색을 다르게 칠하는 것.
     * 그러다가 인접한 정점간의 색이 동일할 경우 NO를 리턴.
     * */

    static int T, V, E;
    static int visit[];
    static ArrayList<Integer>[] con;
    static Queue<Integer> q;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (; T-- > 0; ) {
            V = sc.nextInt();
            E = sc.nextInt();

            q = new LinkedList<Integer>();
            con = new ArrayList[V + 1];
            visit = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                con[i] = new ArrayList();
            }

            for (int i = 1; i <= E; i++) {
                int f = sc.nextInt();
                int t = sc.nextInt();

                con[f].add(t);
                con[t].add(f);
            }

            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (bfs(i)) {
                    isBipartite = false;
                    break;
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static boolean bfs(int start) {
        boolean isError = false;

        q.add(start);
        visit[1] = 1;

        while (!q.isEmpty()) {
            int f = q.remove();
            int toggle_c = visit[f] == 1 ? 2 : 1;
            isError = false;

            for (Integer t : con[f]) {
                if (visit[t] == 0) {
                    q.add(t);
                    visit[t] = toggle_c;
                } else if (visit[f] == visit[t]) {
                    isError = true;
                    break;
                }
            }

            if (isError) break;
        }

        return isError;
    }
}
