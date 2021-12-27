import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Weights Assignment For Tree Edges
public class WeightAssignmentForTreeEdges {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCases; i++) {
            int numVertices = Integer.parseInt(scanner.nextLine());
            int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, Long> dist = new HashMap<>();
            HashMap<Integer, Integer> edges = new HashMap<>();
            boolean isValidPerm = true;
            for (int j = 0; j < numVertices; j++) {
                int node = p[j];
                int parent = b[node - 1];
                if (j == 0 && node != parent) {
                    isValidPerm = false;
                    break;
                } else if (node == parent) {
                    dist.put(node, 0L);
                } else if (!dist.containsKey(parent)) {
                    isValidPerm = false;
                    break;
                } else {
                    long parentDist = dist.get(parent);
                    int prevNode = p[j - 1];
                    long prevDist = dist.get(prevNode);
                    int weight = Math.max(1, (int) (prevDist - parentDist + 1));
                    edges.put(node, weight);
                    dist.put(node, weight + parentDist);
                }
            }
            if (isValidPerm) {
                for (int node = 1; node <= numVertices; node++) {
                    int weight = edges.getOrDefault(node, 0);
                    if (node == numVertices) {
                        System.out.println(weight);
                    } else {
                        System.out.print(weight + " ");
                    }
                }
            } else {
                System.out.println("-1");
            }
        }
    }
}