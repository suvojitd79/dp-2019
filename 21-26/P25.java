/*
	
	Unique Binary Search Trees II:
	
	find nth catalan number
	T(n) = sum of ( T(i) * T(n-i-1) ) where i=0 to n-1  

*/

public class Solution {
    public int numTrees(int A) {
        // find nth catalan number 
        int[] cache = new int[A+1];
        Arrays.fill(cache, 0);
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2;i<=A;i++){
            for(int j=0;j<i;j++)
                cache[i] += cache[j] * cache[i-j-1]; 
        }
        return cache[A];
    }
}
