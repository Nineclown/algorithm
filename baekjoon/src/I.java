import java.io.*;
import java.util.Stack;

public class I {
    /*
     * number: 9012
     * name: 괄호
     * solution: PS, Stack
     * 괄호가 ()() 주어질 때, 올바른 괄호 문자열 VPS 일 경우 YES 를 리턴한다. 아닐 경우, No 를 리턴한다.
     * */

    static int N;
    static Stack VPS;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        VPS = new Stack();

        boolean FLAG;

        while (N-- > 0) {
            input = br.readLine();

            FLAG = true;
            VPS.clear();

            for (char a : input.toCharArray()) {
                if (a == '(') {
                    VPS.push(a);
                } else {
                    if (VPS.empty()) {
                        bw.write("NO" + "\n");
                        FLAG = false;
                        break;
                    }
                    VPS.pop();
                }
            }

            if (FLAG && VPS.empty())
                bw.write("YES" + "\n");
            else if (!VPS.empty())
                bw.write("NO\n");
        }

        br.close();
        bw.close();
    }
}
