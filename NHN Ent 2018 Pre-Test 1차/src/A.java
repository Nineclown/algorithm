import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class A {
    static int[] ret;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        Queue<Integer> inventory = new LinkedList<Integer>();
        ret = new int[6];
        int cnt = 0;
        int zzz;
        while (stringTokenizer.hasMoreTokens()) {
            int tmp = Integer.parseInt(stringTokenizer.nextToken());
            if (inventory.size() < 3)
                inventory.offer(tmp);
            else {
                if (!inventory.contains(tmp)) { //인벤토리에 tmp가 없을 경우, 새로운 아이템이라서 젤 오래된 아이템을 버리고 줍는다.
                    zzz = inventory.poll();
                    writer.write(zzz + "\n");
                    ret[cnt++] = zzz;
                    inventory.offer(tmp);
                } else { //인벤토리에 이미 존재하는 아이템을 또 발견한 경우, 버리지 않고 남을 준다.
                    inventory.poll();
                    inventory.offer(tmp);
                }
            }
        }
        //여기까지 오면 템정리가 끝남.

        if (ret[0] == 0)
            writer.write(0 + "\n");

        reader.close();
        writer.close();

    }
}