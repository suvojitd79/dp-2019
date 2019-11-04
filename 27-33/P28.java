public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int[] nums = new int[A.size()+2];
        int k1 = 1;
        for(int num: A) if(num > 0) nums[k1++] = num;
        nums[0] = 1;
        nums[k1] = 1;
        
        int[][] cache = new int[nums.length][nums.length];
                
        for(int l = 3;l<= nums.length;l++){
            for(int i=0;i<= nums.length-l;i++){
                int j = l + i - 1;
                for(int k = i+1; k<= j-1;k++){                   
                    cache[i][j] = Math.max(cache[i][j], nums[i] * nums[k] * nums[j] + cache[i][k] + cache[k][j]);
                }
            }
        }
        return cache[0][nums.length-1];
    }
}
