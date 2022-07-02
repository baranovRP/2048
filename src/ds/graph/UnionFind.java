package ds.graph;

public abstract class UnionFind {

    // Constructor of Union-find. The size is the length of the root array.
    private UnionFind(int size) {
    }

    public abstract int find(int x);

    public abstract void union(int x, int y);

    public abstract boolean connected(int x, int y);

}
