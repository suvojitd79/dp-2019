public class Solution {
    
    public final int mod = 1000000007;

    
    public int sol(int n,int s, int[][] cache){
        
        if(n == 0) return s == 0 ? 1 : 0;
        
        else if(s == 0) return 1;
        
        
        if(cache[n][s] != -1)
            return cache[n][s];
        
        long ans = 0;
        
        for(int i=0;i<=9;i++){
            
        if(i <= s)
            {
                ans += sol(n-1, s - i, cache) % mod;    
            }
        }
        
        cache[n][s] = (int )(ans % mod);
        
        return cache[n][s];
    }
    
    public int helper(int n,int s){
        
        
        if(n == 0) return s == 0 ? 1 : 0;
        
        else if(s == 0) return 1;
        
        long ans = 0;
        int[][] cache = new int[n+1][s+1];
        for(int[] x:cache) Arrays.fill(x, -1);
        
        
        for(int i=1;i<=9;i++){
        
        if(i <= s){
            ans += sol(n-1, s - i, cache) % mod;
        }
    }
    
    return (int )(ans % mod);
    
    }
    
    
    
    public int solve(int A, int B) {
        
        return helper(A,B);
        
    }
}
