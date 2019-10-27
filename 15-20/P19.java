/*

	Coin Sum Infinite

	You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set. Note : Coins in set S will be unique. Expected space complexity of this problem is O(N). Example :
	Input : 
	    S = [1, 2, 3] 
	    N = 4

	Return : 4

	Explanation : The 4 possible ways are
	{1, 1, 1, 1}
	{1, 1, 2}
	{2, 2}
	{1, 3}    
	Note that the answer can overflow. So, give us the answer % 1000007


*/


import java.util.*;
public class P19 {
    
    // O(mn) space sol.
	public int coinchange2(ArrayList<Integer> A, int B) {
        
        
        int mod = 1000007;
        
        long[][] cache = new long[B+1][A.size()];
        for(int i=0;i<A.size();i++) cache[0][i] = 1;
        
        
        for(int i=1;i<=B;i++){
            for(int j = 0;j<A.size();j++){
                
                long x = i - A.get(j) >= 0 ? cache[i - A.get(j)][j] : 0;
                long y = j -1 >= 0 ? cache[i][j-1] : 0;
                cache[i][j] = (x + y) % mod;
            }
        }
        return (int) (cache[B][A.size()-1] % mod);
    }


    // O(n) space solution

    // O(mn) space sol.
	public int coinchange3(ArrayList<Integer> A, int B) {
        
        
        int mod = 1000007;
        	
        // cache[i] - > stores num of sol for value i
        long[] cache = new long[B+1];
        Arrays.fill(cache, 0);
        cache[0] = 1; // sum
        
        for(int i=0;i<A.size();i++){
            for(int j = A.get(i);j<=B;j++){
                cache[j] += cache[j-A.get(i)];
                cache[j] %= mod;
            }
        }
        return (int) (cache[B] % mod);
    }




    public static void main(String... args){

    	System.out.println(new P19().solve(new int[]{1,2,3}, 4));

    }



}


	



