import java.util.Arrays;

public class A {
    static int b = 0;

    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);

        for (int a : people) {
            for (; b < tshirts.length; ++b) {
                if (tshirts[b] >= a) {
                    answer++;
                    b++;
                    break;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        A a = new A();
        int[] people = {1, 1, 1};
        int[] tshirts = {1};
        int answer;
        answer = a.solution(people, tshirts);

        System.out.println(answer);
    }
}
