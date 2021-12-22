import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Complex Market Analysis
public class ComplexMarketAnalysis {

    public static void solution(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int e = Integer.parseInt(tokens[1]);
            List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map((Integer::parseInt)).collect(Collectors.toList());
            int[] pre = new int[arr.size()];
            long count = 0;
            for (int j = 0; j < arr.size(); j++) {
                pre[j] = arr.get(j) == 1 ? 1 : 0;
                if (j - e >= 0 && arr.get(j) == 1) {
                    pre[j] += pre[j - e];
                }
            }
            int[] suf = new int[arr.size()];
            for (int j = arr.size() - 1; j >= 0; j--) {
                suf[j] = arr.get(j) == 1 ? 1 : 0;
                if (j + e < arr.size() && arr.get(j) == 1) {
                    suf[j] += suf[j + e];
                }
            }
            for (int j = 0; j < arr.size(); j++) {
                if (isPrime(arr.get(j))) {
                    long left = j - e >= 0 ? pre[j - e] : 0;
                    long right = j + e < arr.size() ? suf[j + e] : 0;
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
