import java.io.*;

public class B {
    /*
     * number: 2839
     * name: 설탕배달
     * solution: PS, DP(X. 겹치거나, )
     * D[N] N kg의 설탕을 배달하기 위해 가져 가야하는 봉지의 수.
     * 다이나믹으로 풀려고 했는데 아직 미숙해서 안댐.
     * 그냥 단순히 모든 조건을 검사하는 방법으로 해결.
     * N kg의 설탕을 모든 봉지에 담게 될 때까지(n == 0) 반복한다.
     * 우선 5kg 만으로 모두 담을 수 있는 경우
     * 설탕이 5kg보다 많은데, 3kg에 담지 못하는 경우, --> 5kg에 담는다.
     * 설탕이 3kg보다 많은데, 5kg에 담지 못하는 경우, --> 3kg에 담는다.
     * 설탕이 1kg 또는 2kg인 경우
     * 4가지?
     * 더 간단한 방법도 있는데 B_2에 작성.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n != 0) {
            if (n % 5 == 0) {
                cnt += (n / 5);
                break;
            } else if (n >= 5 && n % 3 != 0) {
                cnt++;
                n = n - 5;
            } else if (n >= 3) {
                cnt++;
                n = n - 3;
            } else if (n == 1 || n == 2) {
                cnt = -1;
                break;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}
