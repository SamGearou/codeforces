package d1000;

import java.util.Arrays;
import java.util.Scanner;

// Triangles on a Rectangle
public class TrianglesOnARectangle {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int w = Integer.parseInt(tokens[0]);
            int h = Integer.parseInt(tokens[1]);
            int[] bottom = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] top = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] left = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] right = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long ans = 0;
            //check bottom
            int[] leftPt = {bottom[1], 0};
            int[] rightPt = {bottom[bottom.length - 1], 0};
            ans = Math.max(ans, doubledArea(leftPt, rightPt, h));

            //check top
            leftPt = new int[]{top[1], h};
            rightPt = new int[]{top[top.length - 1], h};
            ans = Math.max(ans, doubledArea(leftPt, rightPt, h));

            //check left
            int[] bottomPt = {0, left[1]};
            int[] topPt = {0, left[left.length - 1]};
            ans = Math.max(ans, doubledArea(bottomPt, topPt, w));

            //check right
            bottomPt = new int[]{w, right[1]};
            topPt = new int[]{w, right[right.length - 1]};
            ans = Math.max(ans, doubledArea(bottomPt, topPt, w));

            System.out.println(ans);
        }
    }

    public static long doubledArea(int[] one, int[] two, long h) {
        int w = dist(one, two);
        return w * h;
    }

    private static int dist(int[] one, int[] two) {
        double intermediate = Math.pow(one[0] - two[0], 2) + Math.pow(one[1] - two[1], 2);
        return (int) Math.sqrt(intermediate);
    }
}