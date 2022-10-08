package lc;

class UF1 {
    int[] id;
    int[] sz;
    int count;

    UF1(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    int find(int p) {
        while (p != id[p])
            p = find(id[p]);
        return p;
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sz[i] > sz[j]) {
            id[j] = i;
            sz[i] += sz[j];
        } else {
            id[i] = j;
            sz[j] += sz[i];
        }

        count--;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }
}

public class NumberOfProvincesUF  {

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0}, {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1}
        };
        int l = isConnected.length;
        UF1 uf = new UF1(l);
        for (int i = 0; i < l; i++) {
            for (int j = i; j < isConnected[i].length; j++) {
                if(uf.connected(i,j)) continue;
                if (isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }
        System.out.println("expected: 3, actual: " + uf.count());
    }
}

