import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

// Spreadsheets
public class Spreadsheets {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            String str = scanner.next();
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();
            if (matchesPattern(str)) {
                int j = 1;
                while (j < str.length() && str.charAt(j) != 'C') {
                    row.append(str.charAt(j++) + "");
                }
                j++;
                while (j < str.length()) {
                    col.append(str.charAt(j++));
                }
                StringBuilder colStr = convertColToLetters(Integer.parseInt(col.toString()));
                colStr.append(row);
                System.out.println(colStr);
            } else {
                int j = 0;
                while (j < str.length() && Character.isLetter(str.charAt(j))) {
                    col.append(str.charAt(j++) + "");
                }
                while (j < str.length()) {
                    row.append(str.charAt(j++));
                }
                StringBuilder colStr = convertColToNumbers(col.toString());
                System.out.println("R" + row + "C" + colStr);
            }
        }
    }

    private static StringBuilder convertColToNumbers(String colLetters) {
        StringBuilder sb = new StringBuilder();
        int highestPow = colLetters.length() - 1;
        int j = 0;
        int num = 0;
        while (j < colLetters.length()) {
            int digit = colLetters.charAt(j) - 'A' + 1;
            num = num + ((int) (digit * Math.pow(26, highestPow)));
            highestPow--;
            j++;
        }
        sb.append(num);
        return sb;
    }

    private static StringBuilder convertColToLetters(int colNum) {
        int highestPow = 0;
        while (Math.pow(26, highestPow + 1) <= colNum) {
            highestPow++;
        }
        if (shouldBePreviousPower(highestPow, colNum)) {
            highestPow--;
        }
        StringBuilder sb = new StringBuilder();
        while (colNum > 0) {
            int pow = (int) Math.pow(26, highestPow);
            int num = colNum / pow;
            char c = (char) (num + 'A' - 1);
            sb.append(c);
            highestPow--;
            if (num * pow != 0) {
                colNum = colNum % (num * pow);
            }
        }
        while (highestPow-- >= 0) {
            sb.append("@");
        }
        fixUp(sb);
        return sb;
    }

    // r + r^2 + r^3 + ... + r^n = (1 - r^(n+1) / (1 - r)), could use that formula with this function
    private static boolean shouldBePreviousPower(int highestPow, int colNum) {
        double currNum = 0;
        while (highestPow >= 0) {
            currNum = currNum + Math.pow(26, highestPow--);
        }
        return currNum >= colNum;
    }

    private static void fixUp(StringBuilder sb) {
        while (sb.indexOf("@") != -1) {
            int ind = sb.indexOf("@");
            sb.setCharAt(ind, 'Z');
            ind--;
            while (ind >= 0 && ind + 1 < sb.length() && sb.charAt(ind + 1) == 'Z') {
                if (sb.charAt(ind) == 'A') {
                    sb.setCharAt(ind, 'Z');
                } else {
                    sb.setCharAt(ind, (char) (sb.charAt(ind) - 1));
                }
                ind--;
            }
        }
    }

    public static boolean matchesPattern(String str) {
        return Pattern.matches("R[0-9]+C[0-9]+", str);
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

//Learnings (got problem though) - take a bit more time upfront to think of edge cases
