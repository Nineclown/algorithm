import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    /*
     * number: 1759
     * name: 암호 만들기
     * solution: PS, Back-Tracking
     * dfs 처럼 하는 거였나?.
     * */

    static int L, C;
    static char Data[];
    static ArrayList<String> pw;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Data = new char[C];
        pw = new ArrayList<>();

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < Data.length; i++) {
            Data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(Data);

        back(0, 0, "");
        for (String a : pw) {
            writer.write(a + "\n");
        }

        reader.close();
        writer.close();
    }

    static void back(int length, int idx, String arg) {
        if (length == 4) {
            int cnt = 0;
            char chk;
            for (int i = 0; i < arg.length(); i++) {
                chk = arg.charAt(i);
                if (chk == 'a' || chk == 'e' || chk == 'i' || chk == 'o' || chk == 'u') {
                    cnt++;
                }
            }
            if (cnt >= 1 && L - cnt >= 2)
                pw.add(arg);
            return;
        }

        for (; idx < Data.length; idx++) {
            back(length + 1, idx + 1, arg + Data[idx]);
        }
    }
}
