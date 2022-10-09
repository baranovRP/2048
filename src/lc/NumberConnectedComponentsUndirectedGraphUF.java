package lc;

class UF4{
    int [] id;
    int [] sz;
    int count;

    UF4(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    int count(){
        return count;
    }
    boolean connected(int p, int q){
        return find(p)==find(q);
    }
    int find(int p){
        if(p==id[p]) return p;
        return id[p]=find(id[p]);
    }
    void union(int p, int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot)return;

        if(sz[qRoot]>sz[pRoot]){id[pRoot]=qRoot; sz[qRoot]+=sz[pRoot];}
        else{id[qRoot]=pRoot; sz[pRoot]+=sz[qRoot];}

        count--;
    }
}
public class NumberConnectedComponentsUndirectedGraphUF {
    public int countComponents(int n, int[][] edges) {
        UF4 uf= new UF4(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.count();
    }
}
