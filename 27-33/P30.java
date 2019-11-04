public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        Collections.sort(A, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> x, ArrayList<Integer> y){
                return x.get(0) - y.get(0);
            }    
        });
            
            
        int max = 0;
        
        int[] cache = new int[A.size()];
        
        Arrays.fill(cache, 1);        
        
        for(int i=1;i<A.size();i++){
            for(int j=i-1;j>=0;j--){
             
                if(A.get(i).get(1) > A.get(j).get(1) && A.get(i).get(0) > A.get(j).get(0) && cache[i] < cache[j] + 1)
                cache[i] = cache[j] + 1;
                
            }
            
        }
        
        for(int x: cache)
            max = Math.max(max, x);
        
        return max;
        
    }
}
