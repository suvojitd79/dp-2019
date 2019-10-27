/*
Unique Paths in a Grid

Asked in:  
Facebook
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100. 

*/

 public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        
        // edge cases
        if(A.size() == 0) return 0; 
        
        
        
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(A.get(i).get(j) == 1){
                    A.get(i).set(j, -1);
                }
            }
        }
        
        
        for(int i=A.size()-1;i>=0;i--){
            for(int j=A.get(i).size()-1;j>=0;j--){
                
                
                if(A.get(i).get(j) == -1) A.get(i).set(j, 0); 
                else 
                {
                    if(i==A.size()-1 && j == A.get(A.size()-1).size()-1)
                        {
                            A.get(i).set(j, 1);
                        }
                    else{
                            
                    int x = j + 1 < A.get(i).size() ? A.get(i).get(j+1) : 0;
                    int y = i + 1 < A.size() ? A.get(i+1).get(j) : 0;
                    A.get(i).set(j, x + y);
                        
                    }
                }
                    
            }
            
        }
        
        return A.get(0).get(0);
        
    }
}

