import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Chat Bot
public class ChatBot {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        long numCases = scanner.nextLong();
        for (int i = 0; i < numCases; i++) {
            long k = scanner.nextLong();
            long x = scanner.nextLong();
            long l = 1;
            long h = (k * 2) - 1;
            while (l <= h) {
                long mid = l + (h - l) / 2;
                if (isLess(mid, k, x)) {
                    l = mid + 1;
                } else if (isEqual(mid, k, x)) {
                    h = mid - 1;
                } else {
                    h = mid - 1;
                }
            }
            System.out.println(Math.min(l, (k * 2) - 1));
        }
    }

    private static boolean isEqual(long mid, long k, long x) {
        if (mid < k) {
            return sum(mid) == x;
        } else {
            return (sum(k) * 2) - k - sum(k - (mid % k) - 1) == x;
        }
    }

    private static boolean isLess(long mid, long k, long x) {
        if (mid < k) {
            return sum(mid) < x;
        } else {
            return (sum(k) * 2) - k - sum(k - (mid % k) - 1) < x;
        }
    }

    public static long sum(long n) {
        return (n * (n + 1)) / 2;
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

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
