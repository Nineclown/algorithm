import java.io.*;
import java.util.StringTokenizer;

public class H_1 {
    /*
     * number: 11052
     * name: 붕어빵 판매하기 --> 카드 구매하기
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * Bottom-up 방식은 반복으로 구현.
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

        D[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (D[i] < D[i - j] + P[j])
                    D[i] = D[i - j] + P[j];
            }
        }

        writer.write(D[N] + "\n");

        reader.close();
        writer.close();

    }

}
