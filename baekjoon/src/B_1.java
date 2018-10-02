import java.io.*;

public class B_1 {
    /*
     * number: 2839
     * name: 설탕배달
     * solution: PS, DP
     * D[N] N kg의 설탕을 배달하기 위해 가져 가야하는 최소 봉지의 수.
     * D[N-3] 과 D[N-5] 중 최소 값이 D[N]이 되는 것?
     * 3kg과 5kg 봉투만으로 N kg의 설탕을 배달할 수 없는 경우가 있다. 이걸 어떻게 처리해야 하지?
     * N kg의 설탕을 맨 처음에 3kg로 뽑는 경우랑, 5kg로 뽑는 경우 말고 없다. 무조건 2방식으로 뽑아야해
     * 문제에서 주어진 다른 조건이 없자나. 무조건 뽑을 수 있는 방법은 2가지다. 그대신 결과는 하나가 아님.
     * 뽑다가 0kg가 남을 경우는 성공한거고, 음수가 되면 이건 -1을 리턴하게 구현하면 된다.
     *
     * Top-down 방식으로 풀이.
     *
     * 정리
     *
     * D[N]은 N kg 설탕을 5kg 박스와 3kg를 최소한 사용해야 하는 박스의 수. 만약 두 종류의 박스로 모두 담을 수 없는 경우엔 -1을 리턴.
     * 따라서 N kg가 있다고 할 때, 5kg를 처음 퍼가는 방법이랑 3kg를 처음 퍼가는 방법 2가지가 존재한다.
     * D[N] = 1 + D[N-5] 또는 1 + D[N-3] 중 최소 값으로 정의할 수 있다.
     * 그리고 마지막에 0kg가 될 경우엔, 0번의 박스를 사용했다고 생각할 수 있다.
     * D[0] = 0
     * D[-N]의 경우엔? 퍼다가 0kg 밑으로 떨어진 경우는 -1을 뜻한다.
     * */

    static int[] D;
    static int N, ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1];

        ANSWER = dp(N);

        if (ANSWER > 10000000)
            ANSWER = -1;

        bw.write(ANSWER + "\n");

        br.close();
        bw.close();
    }

    static int dp(int n) {
        if(n < 0) return 10000000;
        if(n == 0) return 0;

        if (D[n] > 0) return D[n];
        D[n] = 1 + Math.min(dp(n - 3), dp(n - 5));

        return D[n];
    }
}