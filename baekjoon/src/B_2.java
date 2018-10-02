import java.io.*;

    /*
     * number: 2839
     * name: 설탕배달
     * solution: PS
     * 조건을 5로 못 나눌 경우,
     * 3을 계속 빼준다. 5를 빼주는 경우는 왜 고려 안하지? 이걸 생각하긴 힘들지만, 5를 배주는걸 고려안해도 되는 문젠가봐.
     * 3을 빼다가 결국 5로 나눌 수 있는 경우가 생기면 5로 나누는게 핵심.
     * 11의 경우도 5로 못나누는데 3을 2번 빼니까 5로 나눌 수 있게 된다.
     *
     * 문제의 핵심은 최대한 5로 많이 나누게 해야 하는데, 5로 못나눌 경우 3을 빼줌으로써 5로 나눌 수 있게 만드는 것이다.
     * */
public class B_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int count = 0;

        while (n % 5 != 0) {
            if (n < 0) {
                writer.write(-1 + "\n");
                break;
            }
            n -= 3;
            count++;
        }
        if (n % 5 == 0) {
            count += n / 5;
            writer.write(count + "\n");
        }

        reader.close();
        writer.close();
    }
}

