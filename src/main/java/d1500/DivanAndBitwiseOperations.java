package d1500;

import java.util.Scanner;

// Divan and bitwise operations
public class DivanAndBitwiseOperations {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            long result = expMod(n - 1);
            int seqOr = 0;
            for (int j = 0; j < m; j++) {
                tokens = scanner.nextLine().split(" ");
                seqOr |= Integer.parseInt(tokens[tokens.length - 1]);
            }
            result = (seqOr * result) % 1_000_000_007;
            System.out.println(result);
        }
    }

    private static long expMod(int exp) {
        long mod = 1_000_000_007;
        long result = 1;
        long base = 2;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}

//Learnings: For each bit, how many times will it be included in the answer?

// 1) We can ignore subsequences for which a bit occurs an even number of times. Why?
// 2) What happens if a certain bit position does not show up in any subsequence? How is this case handled?
// 2) So we only need to find all subsequences for which the i-th bit occurs an odd number of times. How many subsequences is this?
// 3) Once we know the number from step 2, we can take the OR of the original sequence (or equivalently, the OR of each of the m contiguous subsegments),
//    and multiply this by the number of odd occurrences of every bit % 10^9 + 7. In other words, if x is the OR of every subsegment, and y is the number
//    of odd occurrences of each bit, then the answer = x^y % 10^9+7
