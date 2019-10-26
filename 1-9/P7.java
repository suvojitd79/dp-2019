/*
	
	Coins in a Line


	There are A coins (Assume A is even) in a line.

	Two players take turns to take a coin from one of the ends of the line until there are no more coins left.

	The player with the larger amount of money wins.

	Assume that you go first.

	Return the maximum amount of money you can win.

	Input Format:

	The first and the only argument of input contains an integer array, A.
	Output Format:

	Return an integer representing the maximum amount of money you can win.
	Constraints:

	1 <= length(A) <= 500
	1 <= A[i] <= 1e5
	Examples:

	Input 1:
	    A = [1, 2, 3, 4]

	Output 1:
	    6

	Explanation 1:
	    
	    You      : Pick 4
	    Opponent : Pick 3
	    You      : Pick 2
	    Opponent : Pick 1
	    
	    Total money with you : 4 + 2 = 6

	Input 2:
	    A = [5, 4, 8, 10]
	    
	Output 2:
	    15

	Explanation 2:

	    You      : Pick 10
	    Opponent : Pick 8
	    You      : Pick 5
	    Opponent : Pick 4
	    
	    Total money with you : 10 + 5 = 15
	Seen this question in a real interview before



*/


import java.util.*;
public class P7{

	public static void main(String[] args){
		System.out.println(new P7().maxcoin(new ArrayList<>(Arrays.asList(46, 12, 42, 67))));
	}

	public int maxcoin(ArrayList<Integer> A) {
	        
	            Point[][] cache = new Point[A.size()][A.size()];
	            
	            
	            for(int i=0;i<cache.length;i++){
	                for(int j=0;j<cache[i].length;j++){
	                    cache[i][j] = new Point();
	                }
	            }
	            
	            for(int i=0;i<A.size();i++){
	                cache[i][i].f = A.get(i);
	            }
	            
	            
	            
	            for(int l=2;l<= cache.length ;l++){
	                for(int i=0;i<= cache.length-l;i++){
	                    
	                    int j = i + l -1;   
	                    
	                    if(A.get(i) + cache[i+1][j].s > cache[i][j-1].s + A.get(j)){
	                        
	                        cache[i][j].f = A.get(i) + cache[i+1][j].s;
	                        cache[i][j].s = cache[i+1][j].f;
	                        
	                    }else{
	                        cache[i][j].f = A.get(j) + cache[i][j-1].s;
	                        cache[i][j].s = cache[i][j-1].f;
	                        
	                    }
	                    
	                }
	                
	            }
	           
	            
	            return cache[0][A.size()-1].f;
	            
	    }


	    
	    class Point{
	        int f,s;
	        Point(){
	            this.f = 0;
	            this.s = 0;
	        }

	        @Override
	        public String toString(){
	        	return "( " + this.f +" "+ this.s + " )";
	        }

	    }


}



