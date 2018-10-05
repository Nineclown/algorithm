import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N {
    /*
     * number: 2621
     * name: 카드 게임
     * solution: PS
     *
     * 모든 조건 9가지에 대해 해결할 수 있는 변수들을 설정해줬다.
     * 변수 갯수만 해도 7개. 얘를 모두 통과하지 못할 경우에 마지막에 리턴해주도록.
     * 9가지 조건중 최상위 1개만 고르기 때문에 if return 처리 함.
     * */

    static int[] Num;
    static char[] Col;
    static int[] Cnt;
    static int[] Max;

    static boolean isSameNum5;
    static boolean isSameNum4;
    static boolean isSameNum3;
    static boolean isSameNum2;
    static boolean isSameNum2_2;
    static boolean isSameCol5;
    static boolean isLinear;

    public static void main(String[] args) throws IOException {
        char t1;
        int t2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        Num = new int[5];
        Cnt = new int[10];
        Max = new int[10];
        Col = new char[5];

        for (int i = 0; i < 5; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            t1 = stringTokenizer.nextToken().charAt(0);
            t2 = Integer.parseInt(stringTokenizer.nextToken());

            Col[i] = t1;
            Num[i] = t2;
        }

        //카드 숫자 판별
        Arrays.sort(Num);
        isLinear = true;
        for (int i = 0; i < 4; i++) {
            if (Num[i] + 1 != Num[i + 1]) {
                isLinear = false;
                break;
            }
        }

        //카드 색 판별
        isSameCol5 = true;
        for (int i = 0; i < 4; i++) {
            if (Col[i] != Col[i + 1]) {
                isSameCol5 = false;
            }
        }

        //카드 숫자 카운팅
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 5; j++) {
                if (Num[j] == i)
                    Cnt[i]++;
            }
        }

        //카드 숫자 판별
        int cnt = 0;
        int a = 0;
        for (int i = 1; i < Cnt.length; i++) {
            a = Cnt[i];
            if (a == 5) {
                isSameNum5 = true;
                Max[5] = i;
            } else if (a == 4) {
                isSameNum4 = true;
                Max[4] = i;
            } else if (a == 3) {
                isSameNum3 = true;
                Max[3] = i;
            } else if (a == 2) {
                cnt++;
                isSameNum2 = true;
                Max[cnt] = i;
            }

            if (cnt == 2)
                isSameNum2_2 = true;
        }

        if (isSameCol5 && isLinear) {
            System.out.println(900 + Num[4]);
            return;
        }

        if (isSameNum4) {
            System.out.println(800 + Max[4]);
            return;
        }

        if (isSameNum3 && isSameNum2) {
            System.out.println(700 + Max[3] * 10 + Max[1]);
            return;
        }

        if (isSameCol5) {
            System.out.println(600 + Num[4]);
            return;
        }

        if (isLinear) {
            System.out.println(500 + Num[4]);
            return;
        }

        if (isSameNum3) {
            System.out.println(400 + Max[3]);
            return;
        }

        if (isSameNum2_2) {
            if (Max[2] > Max[1])
                System.out.println(300 + Max[2] * 10 + Max[1]);
            else
                System.out.println(300 + Max[1] * 10 + Max[2]);

            return;
        }

        if (isSameNum2) {
            System.out.println(200 + Max[1]);
            return;
        }

        System.out.println(100 + Num[4]);

        reader.close();
    }
}
