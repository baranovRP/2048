package lc;

import java.util.Arrays;
import java.util.Comparator;

class UF5{
    int [] id;
    int [] sz;
    int count;

    UF5(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){id[i]=i;sz[i]=1;}
    }
    int count(){
        return count;
    }
    int find(int p){
        if(p==id[p])return p;
        return id[p]=find(id[p]);
    }
    boolean connected(int p, int q){
        return find(p)==find(q);
    }
    void union(int p, int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;

        if(sz[pRoot]<sz[qRoot]){id[pRoot]=qRoot;sz[qRoot]+=sz[pRoot];}
        else{id[qRoot]=pRoot; sz[pRoot]+=sz[qRoot];}

        count--;
    }
}

public class EarliestMomentWhenEveryoneBecomeFriendsUF {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>(){
            public int compare(int[] f, int[] s){
                return f[0]>s[0]?1:-1;
            }
        });
        UF5 uf = new UF5(n);
        for(int[] log:logs){
            uf.union(log[1],log[2]);
            if(uf.count()==1) return log[0];
        }
        return -1;
    }
}
