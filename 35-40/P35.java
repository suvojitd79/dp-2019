public class Solution {
    public int minPathSum(int[][] A) {
        
        if(A.length == 0) return 0;
    
        for(int i=A.length-1;i>=0;i--){
            for(int j=A[i].length-1;j>=0;j--){
                
                int ele = Integer.MAX_VALUE;
                
                if(j+1 < A[i].length)
                    ele = Math.min(ele, A[i][j+1]);
                if(i+1 < A.length)
                    ele = Math.min(ele, A[i+1][j]);
                
                if(ele != Integer.MAX_VALUE)
                    A[i][j] += ele;
                    
            }
        }
        
        return A[0][0];
    }
}
