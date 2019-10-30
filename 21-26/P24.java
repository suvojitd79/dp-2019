public class Solution {
    public int numDistinct(String A, String B) {
        
        int[][] cache = new int[B.length()+1][A.length()+1];
        for(int[] x:cache) Arrays.fill(x, 0);
        // base case b="" vs a="anything" 
        Arrays.fill(cache[0], 1);
        
        for(int i=1;i<=B.length();i++){
            for(int j=i;j<=A.length();j++){
                   
                if(A.charAt(j-1) == B.charAt(i-1)) cache[i][j] = cache[i][j-1] + cache[i-1][j-1];    
                else cache[i][j] = cache[i][j-1];
            }
        }
        return cache[B.length()][A.length()];
    }
    
}
