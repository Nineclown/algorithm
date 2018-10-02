import java.util.*;

public class B {

    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] data = stages;
        int total, cnt;
        HashMap<Integer, Double> fails = new HashMap();

        Arrays.sort(data);

        answer = new int[N];
        cnt = 0;
        total = data.length;

        for (int a : data)
            System.out.print(a + " ");
        System.out.println("");

        //fails를 측정하는 로직.
        for (int i = 1; i <= N; i++) {
            for (int a : data) {
                if (a == i) {
                    cnt++;
                }
                if (a > i)
                    break;
            }

            if (total != 0) {
                fails.put(i, cnt / (double) total);
                total -= cnt;
                cnt = 0;
            } else {
                fails.put(i, (double) 0);
            }


        }

        System.out.println(fails.values());


        Iterator it = sortByValue(fails).iterator();

        int tt = 0;
        while (it.hasNext()) {
            int a = (int) it.next();
            answer[tt] = a;
            tt++;
        }

        return answer;
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                double v1 = (double) map.get(o1);
                double v2 = (double) map.get(o2);

                if (v1 > v2)
                    return 1;
                else return -1;
            }

        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }
    //출처: http://ekfqkqhd.tistory.com/entry/Java-HashMap-Value-정렬 [시우아빠님의 블로그]

    public static void main(String[] args) {
        B b = new B();
        int[] tc = {5, 5, 5, 5, 5, 3, 3};
        int answerB[];
        answerB = b.solution(50, tc);

        for (int bb : answerB)
            System.out.println(bb);
    }
}
