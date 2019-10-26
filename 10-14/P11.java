public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        
        if(A == null || A.size()==0) return 0;
        
        int max = 0, min = A.get(0);
        
        for(int i=1;i<A.size();i++){
            
            max = Math.max(max, A.get(i) - min);    
            min = Math.min(A.get(i), min);
            
        }
        return max;
    }
}
