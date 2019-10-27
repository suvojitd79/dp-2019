public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
    
        int max = 0;
        
        for(int i=1;i<A.size();i++){
            max += A.get(i) > A.get(i-1) ? A.get(i) - A.get(i-1) : 0; 
        }
        return max;
    }
}
