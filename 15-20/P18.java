public class Solution {
    public int chordCnt(int A) {
           
        if(A == 1 || A == 0) return A;   
           
        int mod = 1000000007;
        long[] cache = new long[2*A+1];   
        cache[0] = 1;
        cache[2] = 1;
        
        for(int i=4;i<=2*A;i+=2){
            cache[i] = 0;
            for(int j=0;j<i-1;j+=2){
                cache[i] += ((cache[j] % mod )*(cache[i-2-j] % mod)) % mod;
                cache[i] = cache[i] % mod;
            }
        }
        return (int)(cache[2*A] % mod);
    }
}
