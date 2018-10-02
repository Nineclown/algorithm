import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class A {
    static int C, P;
    static int[] N;
    static int[] Card;
    static int[] ANSWER;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(reader.readLine());
        P = Integer.parseInt(reader.readLine());
        N = new int[P];
        Card = new int[C + 1];
        ANSWER = new int[C + 1];

        for (int i = 0; i < P; i++) {
            N[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 1; i <= C; i++) {
            Card[i] = i;
            ANSWER[i] = i;
        }

        swap(C, 0);

        for(int i = 1; i <= 5; i++) {
            writer.write(ANSWER[i] + "\n");
        }

        reader.close();
        writer.close();

    }

    static void swap(int card, int cnt) {
        if (cnt == P) {
            return;
        }
        int head = N[cnt];
        int body = card - 2 * N[cnt];

        for(int i = 1; i <= body; i++) {
            ANSWER[i] = Card[i + head];
        }
        for(int j = 1; j <= head; j++) {
            ANSWER[body+j] = Card[j];
        }

        int ii = 0;
        for(int a: ANSWER)
            Card[ii++] = a;

        if (card - 2 * N[cnt] > 2 * N[cnt]) {
            swap(card - 2 * N[cnt], cnt);
        } else {
            swap(C, cnt + 1);

        }
    }
}