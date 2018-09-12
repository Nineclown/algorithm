import java.io.*;

public class Main {
    static int N;
    static String input;
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        input = reader.readLine();
        ANSWER = 0;
        for (int i = 0; i < N; i++) {
            ANSWER += input.charAt(i) - 48;
        }

        writer.write(ANSWER + "\n");

        reader.close();
        writer.close();
    }
}
