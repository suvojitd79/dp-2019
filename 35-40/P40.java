import java.util.*;
class P40 {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s.length() == 0) return true;
        
        int len = s.length();
        boolean[][] cache = new boolean[len][len];
        
        
        
        for(int l = 1;l<= len;l++){
            
            for(int i = 0; i<= len - l; i++){
                
                int j = l + i -1;
                
                if(wordDict.contains(s.substring(i,j+1))) cache[i][j] = true;
                else{
                    
                    cache[i][j] = false;
                    
                    for(int k = i + 1; k<=j; k++)
                        if(cache[i][k-1] && cache[k][j]){
                            cache[i][j] = true;
                            break;
                        }
                    
                }
                
            }
            
        }
        
        return cache[0][len-1];
    }


    public 



    public static void main(String[] args){

        P44 p = new P44();
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        List<String> dict = new ArrayList(dictionary);

        System.out.println(p.wordBreak(str, dict));


    }


}