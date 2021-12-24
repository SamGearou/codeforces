import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Paprika and Permutation
public class PaprikaAndPermutation {

    public static void main(String[] args) throws IOException {
        PaprikaAndPermutation.solution();
    }

    private static void solution() throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(scanner.nextInt());
            }
            Collections.sort(arr); //careful, originally used an array, but Array.sort() is O(n^2) in the worst case
            boolean[] seen = new boolean[n + 1];
            int x = 1;
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (arr.get(j) >= 1 && arr.get(j) <= n && !seen[arr.get(j)]) {
                    seen[arr.get(j)] = true;
                } else {
                    if (x * 2 >= arr.get(j)) {
                        break;
                    } else {
                        seen[x] = true;
                        ans++;
                    }
                }
                while (x < seen.length && seen[x]) {
                    x++;
                }
            }
            if (x == n + 1) {
                printWriter.println(ans);
            } else {
                printWriter.println("-1");
            }
        }
        printWriter.close();
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
