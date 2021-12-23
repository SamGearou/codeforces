import java.util.Arrays;
import java.util.Scanner;

//Complex Market Analysis
public class ComplexMarketAnalysis {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int e = Integer.parseInt(tokens[1]);
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] pre = new int[arr.length];
            long count = 0;
            for (int j = 0; j < arr.length; j++) {
                pre[j] = arr[j] == 1 ? 1 : 0;
                if (j - e >= 0 && arr[j] == 1) {
                    pre[j] += pre[j - e];
                }
            }
            int[] suf = new int[arr.length];
            for (int j = arr.length - 1; j >= 0; j--) {
                suf[j] = arr[j] == 1 ? 1 : 0;
                if (j + e < arr.length && arr[j] == 1) {
                    suf[j] += suf[j + e];
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (isPrime(arr[j])) {
                    long left = j - e >= 0 ? pre[j - e] : 0;
                    long right = j + e < arr.length ? suf[j + e] : 0;
                    count = count + left + right + (left * right);
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}
