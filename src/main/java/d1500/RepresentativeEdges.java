package d1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// Representative Edges
public class RepresentativeEdges {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < numCases; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int j = 0; j < arr.length; j++) {
                arr[j] = scanner.nextInt();
                freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            }
            int ans = n - 1;
            for (int key : freq.keySet()) {
                ans = Math.min(ans, n - freq.get(key));
            }
            for (int j = 0; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    double diff = (arr[k] - arr[j]) / (double) (k - j);
                    int l = j - 1;
                    int count = 1;
                    int possAns = 0;
                    while (l >= 0) {
                        if (arr[l] != arr[j] - (diff * count)) {
                            possAns++;
                        }
                        l--;
                        count++;
                    }
                    int m = j + 1;
                    count = 1;
                    while (m < k) {
                        if (arr[m] != arr[j] + (diff * count)) {
                            possAns++;
                        }
                        m++;
                        count++;
                    }
                    int h = k + 1;
                    count = 1;
                    while (h < arr.length) {
                        if (arr[h] != arr[k] + (diff * count)) {
                            possAns++;
                        }
                        h++;
                        count++;
                    }
                    ans = Math.min(ans, possAns);
                }
            }
            printWriter.println(ans);
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
