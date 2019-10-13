/*
	
	Length of Longest bitonic subsequence	
	

*/
import java.util.*;
public class P4{

	public static void main(String[] args){

		new P4().longestSubsequenceLength(new ArrayList<>(Arrays.asList(1,2,3,4,5)));


	}


	public int longestSubsequenceLength(final List<Integer> A) {
        
         if(A.size()==0 || A.size()==1) return A.size();
     
         int[] left = new int[A.size()];
         int[] right = new int[A.size()];
         Arrays.fill(left,1);
         Arrays.fill(right,1);
            
            // increasing subsequence from left
         for(int i=1;i<A.size();i++){
             for(int j=i-1;j>=0;j--){
                 if(A.get(i) > A.get(j) && left[i] < left[j] + 1) left[i] = left[j] + 1;
             }
         }
        
        
            // increasing subsequence from right
         for(int i=A.size()-2;i>=0;i--){
             for(int j=i+1;j<A.size();j++){
                 if(A.get(i) > A.get(j) && right[i] < right[j] + 1) right[i] = right[j] + 1;
             }
         }

        
        int max = left[0] + right[0];
        
        for(int i=1;i<A.size();i++){
            max = Math.max(max, left[i] + right[i]);
        }
        
        return max-1;   
    }

}


