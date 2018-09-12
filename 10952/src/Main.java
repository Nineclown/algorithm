import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    static String input;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        input = reader.readLine();

        do {
            st = new StringTokenizer(input);
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0)
                return;

            writer.write(A + B + "\n");
            writer.flush();
        } while ((input = reader.readLine()) != null);

        reader.close();
        writer.close();
    }
}
