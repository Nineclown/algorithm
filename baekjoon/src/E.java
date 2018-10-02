import java.io.*;

public class E {
    /*
     * number: 11726
     * name: 2 x n 타일링
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * 2 x n 크기의 직사각형에 2가지 타일을 넣어서 채울 수 있는 방법의 수가 D[N]의 값이 된다.
     * 이 문제가 주어졌을 때, DP를 써야한다고 어떻게 유추할 수 있나?
     * 문제를 해결하기 위한 조건이 주어지고 그 조건 외의 다른 조건이 없이 해당 조건만으로 문제를 해결할 수 있을 때,
     * 또한 점화식으로 풀어지는 경우, DP를 쓰면 좋아.
     * DP는 문제를 작게 나눠서 푸는 방법 + 작은 문제들이 서로 겹치는 경우, 이 겹침을 줄임으로써 빠르게 문제를 해결할 때 쓰인다.
     * bottom-up 방식의 경우, 가장 작은 문제로 부터 점점 문제를 키워서 결국 해결해야하는 문제를 푸는 방식이다.
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
            D[i] = (D[i - 1] + (D[i - 2])) % 10007;
        }

        writer.write(D[N] + "\n");

        reader.close();
        writer.close();

    }
}
