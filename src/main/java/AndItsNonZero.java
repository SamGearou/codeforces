import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// And It's Non-Zero
public class AndItsNonZero {

    private static void solution() throws IOException {
        int[][] b = new int[200_001][32];
        for (int i = 1; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = b[i - 1][j];
                if ((i & (1 << j)) != 0) {
                    b[i][j] += 1;
                }
            }
        }
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < numCases; i++) {
            int l = scanner.nextInt();
            int h = scanner.nextInt();
            int ans = Integer.MIN_VALUE;
            for (int j = 0; j < 32; j++) {
                ans = Math.max(ans, b[h][j] - b[l - 1][j]);
            }
            int n = h - l + 1;
            pw.println(n - ans);
        }
        pw.close();
    }

    public static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer st;

        public MyScanner() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bufferedReader.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
