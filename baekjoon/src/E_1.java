import java.io.*;

public class E_1 {
    /*
     * number: 11726
     * name: 2 x n 타일링
     * solution: Dynamic programming
     * top-down 방식의 경우, 앞쪽에서 예외를 처리하고, 재귀호출을 통해 큰 문제를 작은 문제로 나누어 푼다.
     * bottom-up 은 D[n]을 다 만들지만, top-down 의 경우엔 안 그러죠? 걍 재귀함수 반환 값을 써도 되니까 이거 때메 개고생했네 ㅇㄴ
     * */
    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        D = new int[N + 1];

        writer.write(tile(N) + "\n");

        reader.close();
        writer.close();

    }


    static int tile(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (D[n] > 0) return D[n];
        D[n] = (tile(n - 1) + (tile(n - 2))) % 10007;

        return D[n];
    }
}
