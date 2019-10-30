public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
    
        int max = Collections.max(A);
        long[] cache = new long[max+1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        
        for(int i=0;i<B.size();i++){
            for(int j=B.get(i);j<=max;j++)
                cache[j] = Math.min(cache[j-B.get(i)]+C.get(i), cache[j]);
        }
        
        for(Integer x:A) cache[0] += cache[x];
        return (int) cache[0];
    }
}
