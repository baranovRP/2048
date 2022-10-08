package lc;

class UF {
    int[] id;
    int[] sz;
    int count;

    UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            // initial weight
            sz[i] = 1;
        }
    }

    private int find(int p) {
        while (p != id[p])
            p = find(id[p]);

        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count--;
    }

}

public class FindIfPathExistsInGraphUF {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n <= 2) return true;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (!uf.connected(edge[0], edge[1])) uf.union(edge[0], edge[1]);
            if (uf.connected(source, destination)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraphUF fpg = new FindIfPathExistsInGraphUF();
        System.out.println(fpg.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(fpg.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        System.out.println(fpg.validPath(1, new int[][]{}, 0, 0));
        System.out.println(fpg.validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}}, 5, 9));
        System.out.println(fpg.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
