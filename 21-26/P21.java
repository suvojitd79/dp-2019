public class Solution {
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        
        ArrayList<Integer> ans = new ArrayList();
        int n = B.size() + 2;
        int[] p = new int[n];
        p[0] = 0;
        for(int i=0;i<B.size();i++) p[i+1] = B.get(i);
        p[n-1] = A;
        
        long[][] cache = new long[n][n];
        int[][] parent = new int[n][n];
        
        for(long[] x:cache) Arrays.fill(x, 0);
        
        
        for(int l=1;l<=n; l++){
            for(int i=0;i<=n-l;i++){
                int j = l + i -1;   
                for(int k=i+1;k<j; k++){
                    
                    long val = p[j]-p[i] + cache[i][k] + cache[k][j];
                    if(cache[i][j] == 0 || cache[i][j] > val){
                        
                        cache[i][j] = val;
                        parent[i][j] = k;
                    }
                    
                }
                
            }
        }
        
        helper(ans,parent,p,0,n-1);
        
        
        return ans;
    }
    
    
    public void helper(ArrayList<Integer> ans,int[][] parent,int[] p, int i,int j){
        
        if(i+1 >= j) {
            return;
        }
        ans.add(p[parent[i][j]]);
        helper(ans,parent,p,i, parent[i][j]);
        helper(ans,parent,p, parent[i][j],j);

    }
    
    
    
}
