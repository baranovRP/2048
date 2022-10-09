package lc;

class UF3 {
    int[] id;
    int[] sz;
    int count;

    UF3(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }

    int find(int p){
        if(p==id[p]) return p;
        return id[p]=find(id[p]);
    }

    int count(){
        return count;
    }

    boolean connected(int p, int q){
        return find(p)==find(q);
    }

    void union(int p, int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;

        if(sz[pRoot]<sz[qRoot]){ id[pRoot]=qRoot; sz[qRoot]+=sz[pRoot];}
        else{ id[qRoot]=pRoot; sz[pRoot]+=sz[qRoot];}

        count--;
    }
}

public class GraphValidTreeUF {
    public boolean validTree(int n, int[][] edges) {
        UF3 uf = new UF3(n);
        for(int[] edge:edges){
            if(uf.connected(edge[0], edge[1])) return false;
            uf.union(edge[0],edge[1]);
        }
        return uf.count()==1;
    }
}
