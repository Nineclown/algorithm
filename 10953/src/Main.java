import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int TC, A, B;
    static String[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(reader.readLine());

        for (int i = 0; i < TC; i++) {
            input = reader.readLine().split(",");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            writer.write(A + B + "\n");

        }
        reader.close();
        writer.close();
    }
}
