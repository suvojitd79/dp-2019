public class Solution {
    public int solve(String A) {
        
        int n = A.length();
        
        if(n==0) return 0;
        
        int[][] cache = new int[n][n];
        
        for(int i=0;i<n;i++) cache[i][i] = 1;
        
        for(int l=2;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j = l + i - 1;
                if(A.charAt(i) == A.charAt(j)){
                    if(j-i==1)
                        cache[i][j] = 2;
                    else     
                        cache[i][j] = 2 + cache[i+1][j-1];
                }
                else{
                    cache[i][j] = Math.max(cache[i+1][j], cache[i][j-1]);
                }
            }
        }
        
        
        return cache[0][n-1];
    }
}
