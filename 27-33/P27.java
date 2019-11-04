public class Solution {
    Map<String, ArrayList<String>> map;
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
            
        map = new HashMap();
        return helper(A,B);
        
    }
    
    public ArrayList<String> helper(String s, ArrayList<String> words){
        
        if(map.containsKey(s)) return map.get(s);
    
        ArrayList<String> ans = new ArrayList();
    
    
        for(int i=0;i<s.length();i++){
            
            String str = s.substring(0,i+1);
            
            
            if(words.indexOf(str) != -1){
                
                if(str.length() < s.length()){
                    
                    for(String s1: helper(s.substring(i+1), words))
                        ans.add(str + " "+ s1);
                    
                }else
                    ans.add(str);
                
            }
            
        }
    
            
        map.put(s, ans);
        return ans;
    }
}
