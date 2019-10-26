public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        
        if(A.size()<2) return A.size();
        
        int[] cache = new int[A.size()];
        Arrays.fill(cache, 1);
        
        for(int i=1;i<A.size();i++){
            for(int j=i-1;j>=0;j--){
                
                if(A.get(i) > A.get(j) && cache[i] < cache[j] + 1)    
                    cache[i] = cache[j] + 1;
            }
        }
        
        int ans = cache[0];
        for(int i=1;i<A.size();i++) ans = Math.max(ans, cache[i]);
        return ans;
    }
}
