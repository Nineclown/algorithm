import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class K_1 {
    /*
     * number: 1406
     * name: 에디터
     * solution: PS, Stack
     * 한줄로 된 문자열이 주어지고 규칙에 맞춰 문자열을 조작한다. 그리고 그 결과를 출력하라.
     * 커서를 기준으로 왼쪽 스택 오른쪽 스택을 만든다.
     * */

    static Stack<Character> Left;
    static Stack<Character> Right;

    static int N;
    static String CMD;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Left = new Stack<>();
        Right = new Stack<>();

        for (char a : reader.readLine().toCharArray()) {
            Left.push(a);
        }

        N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            CMD = reader.readLine();

            if ("L".equals(CMD)) {
                if (!Left.isEmpty())
                    Right.push(Left.pop());

            } else if ("D".equals(CMD)) {
                if (!Right.isEmpty())
                    Left.push(Right.pop());

            } else if ("B".equals(CMD)) {
                if (!Left.isEmpty())
                    Left.pop();
            } else {
                Left.push(CMD.charAt(2));
            }

        }

        Iterator it = Left.iterator();

        while (it.hasNext()) {
            char a = (char) it.next();
            writer.write(a + "");
        }

        while (!Right.isEmpty())
            writer.write(Right.pop() + "");
        writer.write("\n");

        reader.close();
        writer.close();
    }


}
