import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int A, B;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        writer.write(A + B + "\n");

        reader.close();
        writer.close();
    }
}
