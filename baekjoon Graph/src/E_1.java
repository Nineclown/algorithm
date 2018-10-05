import java.util.Scanner;

public class E_1 {
    public static void dfs(int[] a, boolean[] c, int x) {
        if (c[x]) return;
        c[x] = true;
        dfs(a, c, a[x]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            boolean[] c = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                c[i] = false;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (c[i] == false) {
                    dfs(a, c, i);
                    ans += 1;
                }
            }
            System.out.println(ans);
        }

    }
}