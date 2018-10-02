import java.io.*;

public class B_3 {
    /*
     * number: 2839
     * name: 설탕배달
     * solution: PS, DP
     * D[N] N kg의 설탕을 배달하기 위해 가져 가야하는 최소 봉지의 수.
     * D[N-3] 과 D[N-5] 중 최소 값이 D[N]이 되는 것?
     * bottom-up 방식으로 풀이.
     * */

    static int[] D;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i5;
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1];

        D[0] = 0;
        D[1] = 10000000;
        D[2] = 10000000;

        for (int i = 3; i <= N; i++) {
            i5 = i - 5;

            if (i5 < 0) //여긴 아무거나 상관없음. -1을 의미하는 값만 들어가도 된다.
                i5 = 2;

            D[i] = 1 + Math.min(D[i - 3], D[i5]);
        }


        if (D[N] > 10000000)
            D[N] = -1;

        bw.write(D[N] + "\n");

        br.close();
        bw.close();
    }
}