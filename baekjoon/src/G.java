import java.io.*;

public class G {
    /*
     * number: 9095
     * name: 1, 2, 3 더하기
     * solution: Dynamic programming
     * 문제에서 구하라고 한 값을 D[N]에 넣는게 일반적인 풀이.
     * 1, 2, 3을 사용해 N을 표현하는 방법의 수가 D[N]의 값이 된다.
     * 이게 근데, 조건이 10이하의 N이라서 미리 D[10]까지 다 구해놓고 TC 별로 N만 바꿔서 제출하면 풀리는데,
     * 각 TC 별로 계속 D[N]을 구하는 방식으로 푸니까 런타임 에러(대부분 배열 인덱스 문제)가 발생한다.
     * 이유를 찾지 못함. ㅜ
     * 이유는 N이 1 일때, D[2]는 당연히 범위를 벗어난다. 그런데 D[1, 2, 3]은 내가 그냥 코드로 정의해놓았으니까 터지지.
     * */

    static int TC, N;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        TC = Integer.parseInt(reader.readLine());

    /*    D = new int[11];

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i <= 10; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }
*/
        while (TC-- > 0) {
            N = Integer.parseInt(reader.readLine());
            D = new int[N + 3];

            D[1] = 1;
            D[2] = 2;
            D[3] = 4;
            for (int i = 4; i <= N; i++) {
                D[i] = D[i - 1] + D[i - 2] + D[i - 3];
            }
            writer.write(D[N] + "\n");

        }

        reader.close();
        writer.close();

    }
}
