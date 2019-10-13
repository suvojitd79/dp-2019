/*
	Say you have an array, A, for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

	Return the maximum possible profit.



	Input Format:

	The first and the only argument is an array of integers, A.
	Output Format:

	Return an integer, representing the maximum possible profit.
	Constraints:

	1 <= len(A) <= 7e5
	1 <= A[i] <= 1e7
	Examples:

	Input 1:
	    A = [1, 2]

	Output 1:
	    1

	Explanation:
	    Buy the stock on day 0, and sell it on day 1.

	Input 2:
	    A = [1, 4, 5, 2, 4]

	Output 2:
	    4

	Explanation:
	    Buy the stock on day 0, and sell it on day 2.

*/


import java.util.*;
public class P6{

	public static void main(String[] args){

	}

	public int maxProfit(final List<Integer> A) {
        
        if(A.size()<2) return 0;
        
        // assume buy and sell on day 1
        int p = 0,min = A.get(0);
        
        for(int i=1;i<A.size();i++){
            
            int profit = A.get(i) - min;
            p = Math.max(p, profit);
            min = Math.min(min, A.get(i));
        }
        return p;
    }


}


