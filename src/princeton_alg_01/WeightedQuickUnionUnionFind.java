package princeton_alg_01;

public class WeightedQuickUnionUnionFind {

    private final int[] id; // parent link (indexing by nodes)
    private final int[] sz; // component size for roots (indexed by nodes)
    int counter; // number of components

    WeightedQuickUnionUnionFind(int N) {
        counter = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // the lesser root must point to the greater root
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        counter--;
    }

    // link hops to the root
    int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return counter;
    }

    public static void main(String[] args) {
        WeightedQuickUnionUnionFind uf = new WeightedQuickUnionUnionFind(4);

    }
}
