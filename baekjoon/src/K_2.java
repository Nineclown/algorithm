import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class K_2 {
    /*
     * number: 1406
     * name: 에디터
     * solution: PS
     * 한줄로 된 문자열이 주어지고 규칙에 맞춰 문자열을 조작한다. 그리고 그 결과를 출력하라.
     * L: 커서를 왼쪽으로 옮김.
     * D: 커서를 오른쪽으로 옮김.
     * P: 커서 왼쪽의 문자를 삭제함.
     * P $: 커서 왼쪽에 문자 $를 삽입함.
     * LinkedList를 제대로 사용하는 방법인가보다.
     * 리스트로 앞뒤를 다 접근할 수 있는 ListIterator를 사용함.
     * */

    static LinkedList<Character> Input;
    static ListIterator<Character> idx;
    static int N;
    static String CMD;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        CMD = reader.readLine();
        Input = new LinkedList<>();
        idx = Input.listIterator(Input.size());

        for (int i = 0; i < CMD.length(); i++)
            idx.add(CMD.charAt(i));

        N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            CMD = reader.readLine();
            try {
                if(CMD.equals("L"))
                    idx.previous();
                else if(CMD.equals("D"))
                    idx.next(); //얘랑 밑에 애가 하는 일은 다음 요소나 이전 요소를 가리키는 건데,
                else if(CMD.equals("B")) {
                    idx.previous(); //이전 요소나 다음 요소가 없을 때, 예외를 던지게 구현했다. 그런데 그걸 잡아줘버려서? 계속 진행할 수 있는 건가봐.
                    idx.remove();
                } else {
                    idx.add(CMD.charAt(2));
                }
           } catch (Exception e) {}
        }

        for (char a : Input)
            writer.write(a);

        writer.write("\n");
        reader.close();
        writer.close();
    }
}
