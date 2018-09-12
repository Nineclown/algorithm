import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int L, C;
    static char Data[];
    static ArrayList<String> ANSWER;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Data = new char[C];
        ANSWER = new ArrayList<>();

        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < C; i++) {
            Data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(Data);

        back(0, 0, "");

        for(String a : ANSWER) {
            writer.write(a + "\n");
        }

        reader.close();
        writer.close();
    }

    static void back(int length, int idx, String args) {
        if (L == length) {
            ANSWER.add(args);
            return;
        }


        for (; idx < C; idx++) {
            back(length + 1, idx + 1, args + Data[idx]);
        }

    }
}
