import java.io.*;

public class C {
    /*
     * number: 1003
     * name: 피보나치 함수
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * Zero[N] N 피보나치일 때 0의 수, One[N] N 피보나치일 때 1의 수.
     * 다이나믹 프로그래밍을 적응하기 위해 많이 연습해보는게 좋을 것 같다.
     * 그래도 5개월 동안 손도 못 대던 문제를 풀어서 기분 개조코!
     * */

    static int TC;
    static int N;
    static int D[];
    static int Zero[];
    static int One[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(reader.readLine());

        while (TC-- > 0) {
            N = Integer.parseInt(reader.readLine());
            D = new int[N + 1];
            Zero = new int[N + 1];
            One = new int[N + 1];

            writer.write(fib_Zero(N) + " " + fib_One(N) + "\n");

        }

        reader.close();
        writer.close();
    }

    static int fib_Zero(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;

        if (Zero[n] > 0) return Zero[n];
        Zero[n] = fib_Zero(n - 2) + fib_Zero(n - 1);
        return Zero[n];
    }

    static int fib_One(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (One[n] > 0) return One[n];
        One[n] = fib_One(n - 2) + fib_One(n - 1);
        return One[n];
    }
}
