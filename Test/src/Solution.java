import java.io.*;

public class Solution {
    static int N;
    static String input;
    static char Room[][];
    static int ANSWER;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        Room = new char[N][N];

        for (int i = 0; i < N; i++) {
            input = reader.readLine();
            for(int j = 0; j < N; j++) {
                Room[i][j] = input.charAt(j);
            }
        }


        reader.close();
        writer.close();
    }
}
