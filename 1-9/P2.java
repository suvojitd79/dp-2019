/*
	
	Min Jumps Array	
	


	Given an array of non-negative integers, A, of length N, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Return the minimum number of jumps required to reach the last index.

	If it is not possible to reach the last index, return -1.



*/

import java.util.*;
public class P2{

	public static void main(String[] args){

		System.out.println(minjump(new ArrayList<>(Arrays.asList(1, 3, 6, 1, 0, 9))));

	}


	// O(N^2)
	public static int minjump(ArrayList<Integer> list){

		int[] cache = new int[list.size()];
		Arrays.fill(cache,0);
 		for(int i=2;i<=list.size();i++){

 			int val = Integer.MAX_VALUE;

 			for(int j=list.size()-i+1,step=1;step<=list.get(list.size()-i) && j<list.size();j++,step++){

 				val = Math.min(val, cache[j]);

 			}

 			cache[list.size()-i] = val==Integer.MAX_VALUE? val: 1 + val;
 		}

		return cache[0]==Integer.MAX_VALUE?-1:cache[0];
	}




	// O(N) 
	public int jump(ArrayList<Integer> list) {
        
        if(list.size()<=1) return 0;
        
        if(list.get(0)==0) return -1;
             
        int jump = 1,l = list.get(0), s = list.get(0);
        
        for(int level=1;level<list.size();level++){
            
            
                if(level==list.size()-1) return jump;
                
                if(level+list.get(level) > l) l = level+list.get(level);
               
                s--;
                
                if(s==0){
                    
                    jump++;
                    if(l - level < 0) return -1; // not valid
                    s = l - level;
                    
                }
        }
        return jump;
    }



}


