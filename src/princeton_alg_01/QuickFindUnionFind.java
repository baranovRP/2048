package princeton_alg_01;

public class QuickFindUnionFind {

    private final int[] id;
    int counter;

    QuickFindUnionFind(int size) {
        counter = size;
        id = new int[size];
        for (int i = 0; i < size; i++) id[i] = i;
    }

    void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        // already belongs to the same subset
        if (pId == qId) return;

        // join p to q
        for (int i = 0; i < id.length; i++)
            if (id[i] == pId) id[i] = qId;
        counter--;
    }

    int find(int p) {
        return id[p];
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return counter;
    }

    public static void main(String[] args) {
        QuickFindUnionFind uf = new QuickFindUnionFind(4);

    }
}
