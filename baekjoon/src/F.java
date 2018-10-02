import java.io.*;

public class F {
    /*
     * number: 11727
     * name: 2 x n 타일링2
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * 2 x n 크기의 직사각형에 2가지 타일을 넣어서 채울 수 있는 방법의 수가 D[N]의 값이 된다.
     * */

    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        D = new int[N + 1];

        D[0] = 1;
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            D[i] = (D[i - 1] + 2 * D[i - 2]) % 10007;
        }

        writer.write(D[N] + "\n");

        reader.close();
        writer.close();

    }
}
