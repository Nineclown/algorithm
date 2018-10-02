import java.io.*;
import java.util.Stack;

public class J {
    /*
     * number: 10799
     * name: 쇠막대기
     * solution: PS, Stack
     * 괄호가 ()() 주어질 때, 레이저와 쇠막대기를 구분해서 레이저로 잘려나간 쇠막대기의 총 숫자를 출력해라.
     * 곰곰히 생각하면 풀리는 문제. 이런 문제는 많이 풀어보는 것보다 많이 생각해보는게 좋은 것 같음.
     * */

    static Stack<Integer> Pipe;
    static String Input;
    static int cnt;
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Input = reader.readLine();
        Pipe = new Stack();
        cnt = 0;
        ANSWER = 0;

        for (char a : Input.toCharArray()) {
            if (a == '(') {
                Pipe.push(cnt++);
            } else {
                if (Pipe.peek() + 1 == cnt++) {
                    Pipe.pop();
                    ANSWER += Pipe.size();
                } else {
                    cnt++;
                    Pipe.pop();
                    ANSWER++;
                }
            }
        }

        writer.write(ANSWER + "\n");

        reader.close();
        writer.close();


    }
}
