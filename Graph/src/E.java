import java.io.*;
import java.util.StringTokenizer;

public class E {
    /*
     * number: 2331
     * name: 반복수열
     * solution: PS, DFS
     * 특별한 규칙에 따라 주어진 숫자를 다른 숫자로 변형해서 이어 붙인다. 그러다가 반복이 발생하면 반복하기 전까지의 숫자들의 개수를 리턴한다.
     * 이걸 어떻게 DFS 로 풀까? 고민을 해보자.
     *
     * 이어붙이는 행위를 하나의 정점에 단 하나의 간선을 갖는 형태로 생각해보면
     * 다음 정점은 특별한 규칙을 적용시키고, 그 정점까지의 숫자를 넘겨주도록 구현.
     * 굳이 인접행렬, 인접리스트 없이 바로 dfs 메소드의 인수로 다음 정점을 넣어주도록 구현하는 이런 방식을 잘 이해하는게 중요.
     *
     * */

    static int A, P;
    static int[] Check;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        A = Integer.parseInt(stringTokenizer.nextToken());
        P = Integer.parseInt(stringTokenizer.nextToken());
        Check = new int[1000000];

        int ANSWER = dfs(A, 1);

        writer.write(ANSWER + "\n");
        reader.close();
        writer.close();
    }

    static int pow(int n, int p) {
        int result;
        result = n;
        for (int i = 1; i < p; i++) {
            result *= n;
        }
        return result;

    }

    static int next(int n, int p) {
        int ans;
        ans = 0;
        while(n > 0) {
            ans += pow(n % 10, p);
            n /= 10;
        }
        return ans;
    }


    static int dfs(int n, int cnt) {
        if (Check[n] != 0)
            return Check[n] - 1;

        Check[n] = cnt;
        return dfs(next(n, P), cnt + 1);
    }
}
