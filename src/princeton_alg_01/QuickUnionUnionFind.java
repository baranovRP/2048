package princeton_alg_01;

public class QuickUnionUnionFind {

    private final int[] id;
    int counter;

    QuickUnionUnionFind(int size) {
        counter = size;
        id = new int[size];
        for (int i = 0; i < size; i++) id[i] = i;
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = id[qRoot];
        counter--;
    }

    int find(int p) {
        while (p !=id[p]) p = id[p];
        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return counter;
    }

    public static void main(String[] args) {
        QuickUnionUnionFind uf = new QuickUnionUnionFind(4);

    }
}
