import java.io.*;
import java.util.StringTokenizer;

public class D {
    /*
     * number: 10451
     * name: 순열 사이클
     * solution: PS, DFS
     *
     * 숫자 문자열을 던져주는데 이걸로 간선 만들어서 그래프 그린다음. 사이클이 있는지 확인하면 된다. 다시 시작점을 찾을 수 있으면 이게 사이클이지.
     * 이게 아닌가봐. 사이클이 없어도 돼. 그냥 연결 요수의 수를 구하는 것 처럼 풀어버리네..
     * 왜 그렇게 보였는지 드디어 알았따.
     *
     * 숫자 문자열은 절대 안겹쳐. 10개가 주어진 1~10 까지의 숫자가 한번씩 다 쓰임. 따라서 무조건 10개의 정점에 대해서 사이클이 생길 수 밖에 없음.
     *
     * 또한 여기서 주어진 문제를 잘 읽어보면 정점당 간선이 1개씩 밖에 존재하지 않아서 굳이 인접행렬이나 리스트를 구현할 필요 없이 배열 하나만 써서 풀수 이씀.
     *
     * */

    static int T, N;
    static int[] Edges;
    static int[] Check;
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(reader.readLine());
            Edges = new int[N + 1];
            Check = new int[N + 1];
            ANSWER = 0;

            stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= N; i++) Edges[i] = Integer.parseInt(stringTokenizer.nextToken());

            /*=================여기서 부터 사이클을 구하세요=============*/

            for (int i = 1; i <= N; i++) {
                if (Check[i] == 0) {
                    dfs(i);
                    ANSWER++;
                }
            }

            writer.write(ANSWER + "\n");


        }

        reader.close();
        writer.close();
    }

    static void dfs(int v) {
        if (Check[v] == 1)
            return;
        Check[v] = 1;
        dfs(Edges[v]);
    }


}
