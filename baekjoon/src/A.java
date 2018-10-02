import java.io.*;

public class A {
    /*
    * number: 1463
    * name: 1로 만들기
    * solution: Dynamic programming
    * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
    * N을 몇 번의 연산을 통해 1이 만들어질까? 이 때 연산의 숫자가 D[N]의 값이 된다.
    * */
    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine());
        D = new int[N+1];

        writer.write(dp(N) + "\n");

        reader.close();
        writer.close();
    }

    static int dp(int n) {
        if (n == 1)
            return 0;

        if (D[n] > 0) return D[n];  //이 문장이 다이나믹 프로그래밍의 핵심. 초기값은 0이었지만 여기에 이제 값이 들어갔다면? 바로 리턴.
                                    //만약 단순 재귀였다면 계속 아래의 문장들을 통해 계산했던 값들을 또 계산하고 또 하고 할 텐데
                                    //D[N]에 memoization 함으로써 빠르게 값만 가져올 수 있게 된다.
                                    //다이나믹 프로그래밍의 단점은 메모리 공간을 많이 쓰게 되므로 큰 범위에선 사용하기 힘들다.
        D[n] = dp(n - 1) + 1;

        if (n % 2 == 0) {
            int temp = dp(n / 2) + 1;
            if (D[n] > temp) D[n] = temp;
        }

        if (n % 3 == 0) {
            int temp = dp(n / 3) + 1;
            if (D[n] > temp) D[n] = temp;
        }

        return D[n];
    }
}
