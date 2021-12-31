package d1300;

import java.util.Arrays;
import java.util.Scanner;

// Array and Operations
public class ArrayAndOperations {

    private static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int k = Integer.parseInt(tokens[1]);
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long ans = findMin(arr, k);
            System.out.println(ans);
        }
    }

    private static long findMin(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] right = new int[k];
        int[] left = new int[k];
        int i = n - 1;
        int copyK = k;
        while (copyK > 0) {
            right[--copyK] = arr[i--];
        }
        copyK = k;
        while (copyK > 0) {
            left[--copyK] = arr[i--];
        }
        long ans = 0;
        while (i >= 0) {
            ans += arr[i--];
        }
        for (i = 0; i < left.length; i++) {
            ans += (left[i] / right[i]);
        }
        return ans;
    }
}