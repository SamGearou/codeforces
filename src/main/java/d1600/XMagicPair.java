package d1600;

import java.util.Scanner;

// X-Magic Pair
public class XMagicPair {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            long a = Long.parseLong(tokens[0]);
            long b = Long.parseLong(tokens[1]);
            long x = Long.parseLong(tokens[2]);
            isMagicPair(a, b, x);
        }
    }

    public static void isMagicPair(long a, long b, long x) {
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (a == 0 || b == 0) {
            System.out.println("NO");
        } else if (a == x || b == x) {
            System.out.println("YES");
        } else if (x > a && x < b && x % a == b % a) {
            System.out.println("YES");
        } else {
            b = b % a;
            isMagicPair(a, b, x);
        }
    }
}

//Learnings:
// 1) Draw out the recursive tree. You only need to go to the right, the left subtrees you can skip completely as
//    they are a repeat of the right subtrees.
// 2) We can show that if there is a magic pair, x = b - ka --> x % a = b % a - (ka) % a, ka % a = 0 --> x % a = b % a.
//    Of course, x = a OR x = b initially (or at a recursive step).