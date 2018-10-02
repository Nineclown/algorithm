import java.io.*;

public class A_1 {
    /*
     * number: 1463
     * name: 1로 만들기
     * solution: Dynamic programming //Bottom - up 방식으로 구현한다.
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

        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0 && D[i] > D[i/2] + 1)
                D[i] = D[i/2] + 1;
            if (i % 3 == 0 && D[i] > D[i/3] + 1)
                D[i] = D[i/3] + 1;
        }

        writer.write(D[N] + "\n");


        reader.close();
        writer.close();
    }
}
