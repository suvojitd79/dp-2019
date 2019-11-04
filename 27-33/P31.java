public class Solution {
    public int solve(int[] A) {
        
        int max = 0;
        int n = A.length;
        
        Map<Integer,Integer>[] cache = new HashMap[n]; 
        
        for(int i=0;i<n;i++){
            
            cache[i] = new HashMap();
            
            for(int j=0;j<i;j++){
                
                
                if((long)A[i]-A[j] > Integer.MAX_VALUE || (long)A[i]-A[j] < Integer.MIN_VALUE) continue; 
                
                
                int count = cache[j].getOrDefault(A[i]-A[j], 0);
                cache[i].put(A[i]-A[j], cache[i].getOrDefault(A[i]-A[j],0) + count + 1);
                max += count;   
            }
            
            
        }
        
        return max;
    }
}
