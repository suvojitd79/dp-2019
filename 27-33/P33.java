class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                if(i==0) cache[i][j] = j;
                else if(j==0) cache[i][j] = i;
                else if(str1.charAt(i-1) == str2.charAt(j-1)) cache[i][j] = 1 + cache[i-1][j-1];
                else cache[i][j] = 1 + Math.min(cache[i-1][j], cache[i][j-1]);
            }
        }
        
        int len = cache[str1.length()][str2.length()];
        
        char[] ans = new char[len];
        
        
        int i = str1.length(), j = str2.length();
        
        while(i > 0 && j > 0){
            
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                
                ans[--len] = str1.charAt(i-1);
                i--;
                j--;
            }else if(cache[i-1][j] < cache[i][j-1]){
                
                ans[--len] = str1.charAt(i-1);
                i--;
            }else{
                ans[--len] = str2.charAt(j-1);
                j--;
            }
            
        }
        
        while(i>0){
            ans[--len] = str1.charAt(i-1);
            i--;
        }
        
        
        while(j>0){
            ans[--len] = str2.charAt(j-1);
            j--;
        }
        return new String(ans);
    }
}