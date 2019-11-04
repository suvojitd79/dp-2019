/*
Given a stringof lower case alphabets A of size N Return the count of all distinct subsequences of A%10^9+7. 
*/

public class Solution {
    public int solve(String A) {
        
        int mod = 1000000007;
        int MAX_CHAR = 256;
        
        int[] visited = new int[MAX_CHAR]; 
        Arrays.fill(visited, -1); 
                  
        long[] cache = new long[A.length() + 1];
        
        cache[0] = 1;
        
        for(int i=1;i<=A.length();i++){
            
            cache[i] = cache[i-1] * 2; 
            cache[i] %= mod;
            if(visited[(int)A.charAt(i-1)] != -1) {
                cache[i] -= cache[visited[(int)A.charAt(i-1)]];
                if(cache[i] < 0)
                    cache[i] += mod;
            } 
            visited[(int)A.charAt(i-1)] = i-1;
        }
        
        return (int)((cache[A.length()]-1) % mod);
    }
}
