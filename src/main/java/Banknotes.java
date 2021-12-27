import java.util.Arrays;
import java.util.Scanner;

// Banknotes
public class Banknotes {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int k = Integer.parseInt(tokens[1]) + 1;
            int[] denominations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long num = 0;
            for (int j = 0; j < denominations.length; j++) {
                long currDenom = (int) Math.pow(10, denominations[j]);
                long nextDenom = j + 1 < denominations.length ? (int) Math.pow(10, denominations[j + 1]) : -1;
                long next = j + 1 < denominations.length ? (nextDenom / currDenom) - 1 : Integer.MAX_VALUE;
                long used = Math.min(k, next);
                num += (currDenom * used);
                k -= used;
            }
            System.out.println(num);
        }
    }
}

//Learnings: how to minimize f(s)?
// 1) select the max number of 1's, then the max number of 10's, then the max number of 100's, etc
// 2) The most 1's you can select is Math.min(kLeft, 10/1 - 1), 10's --> Math.min(kLeft, 100/10 - 1), and so on