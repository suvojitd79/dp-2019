public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        
        Collections.sort(A);
        int sum = 0;
        for(Integer x:A) sum+=x;
        sum/=2; //required sum
        int[] cache = new int[sum+1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for(int i=0;i<A.size();i++){
            for(int j = sum;j>=A.get(i);j--){
                if(cache[j-A.get(i)] != Integer.MAX_VALUE) 
                    cache[j] = Math.min(cache[j], cache[j-A.get(i)] + 1);
            }
        }
        
        for(int i=sum;i>=0;i--){
            if(cache[i] != Integer.MAX_VALUE) return cache[i];
        }
        return 0;
    }
}
