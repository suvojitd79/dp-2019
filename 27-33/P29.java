public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int n = A.size();
        int[][] cache = new int[n][n];
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        
        for(int i=0;i<n;i++){
            
            map.put(A.get(i), i);
            
            for(int j=0;j<i;j++){
                      
                int index = map.getOrDefault(A.get(i) - A.get(j), -1);
                
                cache[j][i] = (A.get(i) - A.get(j) < A.get(j) && index >=0 ) ? cache[index][j] + 1 : 2;
                
                ans = Math.max(ans, cache[j][i]);
            }
            
        }
        return ans > 2 ? ans : 0;
    }
}
