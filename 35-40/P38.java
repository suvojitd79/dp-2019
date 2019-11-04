public class Solution {
    public int coinchange2(int[] A, int B) {
        int mod = 1000007;
        int[] cache = new int[B+1];
        cache[0] = 1;
        for(int i=0;i<A.length;i++)
            for(int j=A[i];j<=B;j++)
                {
                    cache[j] += cache[j - A[i]];
                    cache[j] %= mod;
                    
                }    
        return cache[B] % 1000007;        
    }
}
