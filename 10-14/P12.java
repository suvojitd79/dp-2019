public class Solution {
    
    class Profit{
        int first,second;
        Profit(int x,int y){
            this.first = x;
            this.second = y;
        }
    }
    
    public int maxcoin(ArrayList<Integer> A) {
        
        Profit[][] cache = new Profit[A.size()][A.size()];
        for(int i=0;i<A.size();i++) cache[i][i] = new Profit(A.get(i), 0);
        
        for(int l=2;l<=A.size();l++){
            for(int i=0;i<A.size()-l+1;i++){
                
                int j = l + i - 1;
                int f,s;
                
                if(A.get(i) + cache[i+1][j].second > A.get(j) + cache[i][j-1].second){
                    
                    f = A.get(i) + cache[i+1][j].second;
                    s = cache[i+1][j].first;
                    }else{
                        
                    f = A.get(j) + cache[i][j-1].second;
                    s = cache[i][j-1].first;
                    }  
                cache[i][j] = new Profit(f,s);    
            }
        }
        
        return cache[0][A.size()-1].first;
    }
    
}
