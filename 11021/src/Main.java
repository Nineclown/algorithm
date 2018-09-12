import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int TC, A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        TC = Integer.parseInt(reader.readLine());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(reader.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            writer.write("Case #" + (i+1) + ": " + (A + B) + "\n");

        }
        reader.close();
        writer.close();
    }
}
