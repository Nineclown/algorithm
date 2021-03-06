import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class K {
    /*
     * number: 1406
     * name: 에디터
     * solution: PS
     * 한줄로 된 문자열이 주어지고 규칙에 맞춰 문자열을 조작한다. 그리고 그 결과를 출력하라.
     * L: 커서를 왼쪽으로 옮김.
     * D: 커서를 오른쪽으로 옮김.
     * P: 커서 왼쪽의 문자를 삭제함.
     * P $: 커서 왼쪽에 문자 $를 삽입함.
     * 해결 방법: ArrayList 에 문자열을 입력받고, 커서 인덱스를 이용해서 들어온 입력들을 처리한다.
     * 이렇게 하니까 시간 초과 뜬다.
     * */

    static ArrayList<Character> Input;
    static int N;
    static int Cursor;
    static String CMD;
    static char value;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Input = new ArrayList();
        for (char a : reader.readLine().toCharArray()) {
            Input.add(a);
        }

        Cursor = Input.size();
        N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            CMD = reader.readLine();

            if ("L".equals(CMD)) {
                if (Cursor != 0)
                    Cursor--;

            } else if ("D".equals(CMD)) {
                if (Cursor != Input.size())
                    Cursor++;

            } else if ("B".equals(CMD)) {
                if (Cursor != 0) {
                    Input.remove(--Cursor);
                }

            } else {
                value = CMD.charAt(2);
                Input.add(Cursor, value);
                Cursor++;
            }

        }

        Iterator it = Input.iterator();

        while (it.hasNext()) {
            char a = (char) it.next();

            writer.write(a+"");
        }
        writer.write("\n");

        reader.close();
        writer.close();
    }


}
