package lc;

public class NumberOfProvinces {

    private int find(int x, int[] root) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x], root);
    }

    private void union(int x, int y, int[] root, int[] rank) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX != rootY) {
            if (rank[x] > rank[y]) {
                root[rootY] = rootX;
            } else if (rank[x] < rank[y]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    private boolean isConnected(int x, int y, int[] root) {
        return find(x, root) == find(y, root);
    }

    public int findCircleNum(int[][] isConnected) {

        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        int n = isConnected.length;
        int provinces = n;
        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j && !isConnected(i, j, root)) {
                    union(i, j, root, rank);
                    provinces--;
                }
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        System.out.println(np.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(np.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(np.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
        System.out.println(np.findCircleNum(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }
}

/* //leetcode solution
class NumberOfProvinces {
    // Union Find
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount() {
            return count;
        }
    }
}
*/
