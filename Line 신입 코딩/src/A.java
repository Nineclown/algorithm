import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

    static int Card;

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        Card = 20000;

        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            if (distance < 4 || distance > 178) {
                System.out.println(Card);
                return;
            }

            else if (distance <= 40)
                if (Card - 720 >= 0) {
                    Card -= 720;
                } else {
                    System.out.println(Card);
                    return;
                }
            else {

                int add = 1 + (distance - 40) / 8;
                if ((distance - 40) % 8 == 0)
                    add--;

                if (Card - (720 + (80 * add)) >= 0)
                    Card -= (720 + (80 * add));
                else {
                    System.out.println(Card);
                    return;
                }
            }
        }
        System.out.println(Card);
    }
}