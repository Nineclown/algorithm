import java.io.*;

public class I_1 {
    /*
     * number: 9012
     * name: 괄호
     * solution: PS, Stack
     * 괄호가 ()() 주어질 때, 올바른 괄호 문자열 VPS 일 경우 YES 를 리턴한다. 아닐 경우, No 를 리턴한다.
     * 굳이 스택 클래스를 사용하지 않고 단순히 카운팅만 해서 구해도 된다 이문제에 경우엔.
     * 그리고 Continue Loop1 구문을 이용해서 반복문 간의 이동을 자유롭게 제어할 수 있는 연습도 해봤다.
     * */
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());

        Loop1 :while (N-- > 0) {
            String Input = reader.readLine();
            cnt = 0;

           for (char a : Input.toCharArray()) {
                if (a == '(') cnt++;
                else cnt--;

                if (cnt < 0) {
                    writer.write("NO\n");
                    continue Loop1;
                }
            }
            if (cnt == 0)
                writer.write("YES\n");
            else
                writer.write("NO\n");
        }

        reader.close();
        writer.close();

    }
}
