import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Blue-Red Permutation
public class BlueRedPermutation {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int n = scanner.nextInt();
            List<Pair> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add(new Pair(scanner.nextInt(), '1'));
            }
            String colors = scanner.next();
            for (int j = 0; j < colors.length(); j++) {
                Pair updatedPair = arr.get(j);
                updatedPair.setColor(colors.charAt(j));
                arr.set(j, updatedPair);
            }
            arr.sort((a, b) -> {
                if (a.color == b.color) {
                    return a.val - b.val;
                }
                return a.color - b.color;
            });
            int x = 1;
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                int val = arr.get(j).val;
                char color = arr.get(j).color;
                if (val < x) {
                    if (color == 'B') {
                        isValid = false;
                    }
                }
                if (val > x) {
                    if (color == 'R') {
                        isValid = false;
                    }
                }
                x++;
            }
            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static class Pair {
        private int val;
        private char color;

        public Pair(int val, char color) {
            this.val = val;
            this.color = color;
        }

        public void setColor(char color) {
            this.color = color;
        }
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

// Learnings: How can we do this greedily? Hint: Take an existing valid permutation, and try to reason about the order of red/blue numbers
// 1) It can be shown that for all valid arrays that can be converted to correct permutations, you can select all blue numbers followed by all red numbers
// 2) Sort array of numbers (blue numbers also coming before red numbers)
// 3) Now consider separately two red numbers 𝑎𝑖 and 𝑎𝑗 such that 𝑎𝑖>𝑎𝑗. If 𝑥 is produced by increasing 𝑎𝑖 and 𝑦 is
// produced by increasing 𝑎𝑗, and in the same time 𝑥<𝑦 then 𝑦>𝑥⩾𝑎𝑖>𝑎𝑗, and the following is also true: 𝑥>𝑎𝑗 and 𝑦>𝑎𝑖.
// So we just showed that if an answer exists, it also exists if greater numbers are produced by greater values
// from the input. The same holds for the blue numbers
