import java.io.*;
import java.util.StringTokenizer;

public class H {
    /*
     * number: 11052
     * name: 붕어빵 판매하기 --> 카드 구매하기
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * D[N]: N개의 카드를 구매하기 위해 필요한 최대 금액.
     * */

    static int N;
    static int[] P;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(reader.readLine());
        P = new int[N + 1];
        D = new int[N + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        writer.write(dp(N) + "\n");

        reader.close();
        writer.close();

    }


    static int dp(int n) {
        int temp = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return P[1];
        if (D[n] > 0) return D[n];
        for (int i = 1; i <= n; i++) {
            temp = dp(n - i) + P[i];

            if (temp > D[n])
                D[n] = temp;
        }


        return D[n];
    }
}
