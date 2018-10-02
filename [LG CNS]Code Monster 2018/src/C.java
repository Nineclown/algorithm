import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/*
* 공격력을 기준으로 정렬한 다음
* 조합을 하는 문제?
* 최대한 많이 고르는 방법 <-- 이걸 찾아서 해당하는 인덱스들을 정렬해서 output.
*
* */
public class C {
    public int[] solution(int[] healths, int[][] items) {
        int[] answer = {};

        ArrayList<int[]> numbering = new ArrayList<>();
        ArrayList<int[]> copy = new ArrayList<>();

        for(int[] a : items) {
            numbering.add(a);
            copy.add(a);
        }

        Collections.sort(copy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = o1[0];
                int v2 = o2[0];
                if (v1 < v2)
                    return 1;
                else return -1;
            }
        });


        Iterator it = copy.iterator();
        while(it.hasNext()) {
            int[] a = (int[])it.next();
            System.out.println(a[1]);
        }

        return answer;
    }


    public static void main(String[] args) {
        C c = new C();

        int[] healths = {200, 120, 150};
        int[][] items = {{30, 100}, {500, 30}, {100, 400}};

        c.solution(healths, items);
    }


}
