import java.io.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        A = Integer.parseInt(reader.readLine());
        B = Integer.parseInt(reader.readLine());

        writer.write(A + B + "\n");

        reader.close();
        writer.close();
    }
}
