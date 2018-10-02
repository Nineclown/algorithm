import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D {
    static int[] visited;
    static ArrayList<Integer> neighbors[];

    public int[] solution(int N, int[][] directory, int[][] query) {
        int[] answer = {};

        neighbors = new ArrayList[N + 1];
        visited = new int[N + 1];
        answer = new int[query.length];
        for (int i = 1; i <= N; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int[] a : directory) {
            int x = a[0];
            int y = a[1];
            neighbors[x].add(y);
            neighbors[y].add(x);
        }

        int cn = 0;
        for (int[] a : query) {
            int start = a[0];
            int end = a[1];

            Arrays.fill(visited, 0);
            answer[cn++] = bfs(start, end);
        }

        return answer;
    }

    static int bfs(int n, int m) {
        Queue<Integer> neighbor = new LinkedList();
        int cnt = 1;
        if (n == m)
            return 1;
        neighbor.add(n);
        neighbor.add(cnt);
        visited[n] = 1;

        while (!neighbor.isEmpty()) {
            n = neighbor.remove();
            cnt = neighbor.remove();

            for (int a : neighbors[n]) {

                if (visited[a] == 1)
                    continue;

                neighbor.add(a);
                neighbor.add(cnt + 1);
                if (a == m) {
                    return cnt + 1;
                }
                visited[a] = 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        //int[][] direct = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        //int[][] quer = {{1, 5}, {2, 5}, {3, 5}, {4, 5}};
        int[][] direct = {{3, 2}, {3, 1}, {3, 4}};
        int[][] quer = {{4, 2}, {2, 4}, {2, 2}};

        int[] ans;

        D d = new D();
        ans = d.solution(5, direct, quer);

        for (int a : ans) {
            System.out.println(a);
        }
    }
}
