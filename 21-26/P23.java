import java.util.*;

public class P23{

	public ArrayList<Integer> solve(String s) {
        int mod = 1000000007;
        
        
		int n = s.length();
		ArrayList<Integer> ans = new ArrayList();
		long[][] cache = new long[n][n];

		for(long[] x:cache) Arrays.fill(x, 0);
		char[] str = s.toCharArray(); 	

		for(int len = n-1;len>=0;len--){
			for(int i=0;i< n-len;i++){

				int j = i + len;

				if(i==0 && j==n-1){

					if(str[i] == str[j]) 
						cache[i][j] = 2;
					else
						cache[i][j] = 1;
				}
				else if(str[i] == str[j]){
					if(i-1 >=0)
						{
						    cache[i][j] += cache[i-1][j];
						    cache[i][j] %= mod;	
						}
					if(j+1 < n){
						cache[i][j] += cache[i][j+1];
					    cache[i][j] %= mod;	
					} 
					if(i-1 < 0 || j+1 >= n){
						cache[i][j] += 1;
                        cache[i][j] %= mod;	
					}

					}	
					else{

					if(i-1 >=0){
						cache[i][j] += cache[i-1][j];
				        cache[i][j] %= mod;	
					}if(j+1 < n){
						cache[i][j] += cache[i][j+1];
						cache[i][j] %= mod;	
					}if(i-1 >=0 && j+1 < n){
						cache[i][j] -= cache[i-1][j+1];
			            if(cache[i][j] < 0) 
			                cache[i][j] += mod;
					}
				}

			}
		    
		}

		for(int i=0;i<n;i++){

			if(i==0 || i==n-1)
				ans.add(1);
			else
				ans.add((int)(cache[i-1][i+1]));
		}	

		return ans;
        
    }

	public static void main(String[] args){


		System.out.println(new P23().solve("xyzx"));


	}



}