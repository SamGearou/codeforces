package d1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Poisoned Dagger
public class PoisonedDagger {

    public static void main(String[] args) throws IOException {
        PoisonedDagger.solution();
    }

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < numCases; i++) {
            int n = scanner.nextInt();
            long health = scanner.nextLong();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            long l = 1;
            long h = (long) 1e+18;
            while (l <= h) {
                long mid = l + (h - l) / 2;
                if (doesWork(mid, arr, health)) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            printWriter.println(Math.min(l, (long) 1e+18));
        }
        printWriter.close();
    }

    private static boolean doesWork(long duration, int[] arr, long health) {
        long damage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                damage += (Math.min(arr[i + 1] - arr[i], duration));
            } else {
                damage += duration;
            }
            if (damage >= health) {
                return true;
            }
        }
        return false;
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

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
