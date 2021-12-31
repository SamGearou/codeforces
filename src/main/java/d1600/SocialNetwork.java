package d1600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// Social Network
public class SocialNetwork {

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int num = Integer.parseInt(tokens[0]);
        int conditions = Integer.parseInt(tokens[1]);
        DSU dsu = new DSU(num);
        int extra = 0;
        for (int i = 0; i < conditions; i++) {
            String[] friends = scanner.nextLine().split(" ");
            int x = Integer.parseInt(friends[0]) - 1;
            int y = Integer.parseInt(friends[1]) - 1;
            if (dsu.findSet(x) != dsu.findSet(y)) {
                dsu.union(x, y);
            } else {
                extra++;
            }
            HashMap<Integer, Integer> setSize = new HashMap<>();
            for (int j = 0; j < num; j++) {
                int parent = dsu.findSet(j);
                setSize.put(parent, setSize.getOrDefault(parent, 0) + 1);
            }
            ArrayList<Integer> sizes = new ArrayList<>();
            for (int key : setSize.keySet()) {
                sizes.add(setSize.get(key));
            }
            Collections.sort(sizes);
            int sum = 0;
            int last = sizes.size() - 1;
            for (int j = 0; j < extra + 1; j++) {
                sum += sizes.get(last--);
            }
            System.out.println(sum - 1);
        }
    }

    public static class DSU {
        private int[] parents;
        private int[] rank;

        public DSU(int n) {
            this.parents = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int findSet(int x) {
            if (parents[x] != x) {
                parents[x] = findSet(parents[x]);
            }
            return parents[x];
        }

        public int union(int x, int y) {
            return link(findSet(x), findSet(y));
        }

        public int link(int x, int y) {
            if (rank[x] < rank[y]) {
                parents[x] = y;
                return y;
            } else {
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
                parents[y] = x;
                return x;
            }
        }
    }
}
