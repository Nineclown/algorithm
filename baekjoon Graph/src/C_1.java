import java.util.ArrayList;
import java.util.Scanner;

public class C_1 {
    /*
     * number: 1707
     * name: 이분 그래프
     * solution: PS, DFS, BFS
     *
     * 백준 알고리즘 홈페이지에서 풀이 방식. 이 경우엔 dfs를 일반적으로 돌리고 나서
     * 모든 정점을 확인한다. 그래서 하나라도 이웃 정점이 같은 색인 경우에 NO를 리턴하도록 구현
     * */
    public static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(a, color, y, 3 - c);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }

            int[] color = new int[n + 1];
            boolean ok = true;
            //여기가 일반적으로 dfs 를 돌리는 곳
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    dfs(a, color, i, 1);
                }
            }

            //다 돌리고 나서 모든 정점을 다 검사.
            Loop1:
            for (int i = 1; i <= n; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) {
                        ok = false;
                        break Loop1;
                    }
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }

    }
}