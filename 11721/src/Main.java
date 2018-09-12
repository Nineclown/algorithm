import java.io.*;

public class Main {
    static int N;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input = reader.readLine();
        N = input.length() / 10;


        if (N != 0) {
            for (int i = 0; i < N; i++)
                writer.write(input.substring(10 * i, 10 * (i + 1)) + "\n");

        }

        writer.write(input.substring(N * 10));

        reader.close();
        writer.close();
    }
}
