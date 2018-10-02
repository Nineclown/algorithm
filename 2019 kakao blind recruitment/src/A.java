import java.util.HashMap;
import java.util.StringTokenizer;

class A {

    public String[] solution(String[] record) {
        StringTokenizer st;
        HashMap<String, String> uid = new HashMap();
        int cnt = 0;
        String first;
        String second;
        String third;
        String[] answer;

        first = null;
        second = null;
        third = null;

        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            first = st.nextToken();
            second = st.nextToken();

            if (first.equals("Leave")) {
                cnt++;
            } else {
                third = st.nextToken();
                uid.put(second, third);
                if (first.equals("Enter"))
                    cnt++;
            }
        }

        answer = new String[cnt];

        first = null;
        second = null;
        third = null;

        int count = 0;
        for (int j = 0; j < record.length; j++) {
            st = new StringTokenizer(record[j]);
            first = st.nextToken();
            second = st.nextToken();

            if (first.equals("Enter")) {
                answer[count++] = uid.get(second) + "님이 들어왔습니다.";
            } else if (first.equals("Leave")) {
                answer[count++] = uid.get(second) + "님이 나갔습니다.";
            } else {

            }
        }

        return answer;

    }

    public static void main(String[] args) {
        A a = new A();
        String[] record = {"Enter uid1234 Prodo", "Leave uid1234", "Change uid1234 Test", "Enter uid1234 Prodo"};
        String[] answerA = a.solution(record);

        for (String aa : answerA)
            System.out.println(aa);

    }

}