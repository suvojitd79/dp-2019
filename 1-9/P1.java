/*
	
	Max Product Subarray	

	intuition:
	for each element the max can be found from the following 3 ways 
	 	- e(+ve) * max_prod(+ve)
	 	- e(-ve) * min_prod(-ve) 
		- e 
*/

public class P1{

	public static void main(String[] args){


	}

    public int maxProduct(final List<Integer> A) {
        
        int max_prod = A.get(0);
        int min_prod = A.get(0);
        int global_max = A.get(0);
        
        for(int i=1;i<A.size();i++){
            
            int max_so_far = max(A.get(i)*max_prod,A.get(i)*min_prod,A.get(i));
            int min_so_far = min(A.get(i)*max_prod,A.get(i)*min_prod,A.get(i));
            global_max = Math.max(global_max, max_so_far);
            max_prod = max_so_far;
            min_prod = min_so_far;
        }
        
        return global_max;
    }
    
    public int max(int x,int y,int z){
        
        return Math.max(Math.max(x,y),z);
        
    }
    
    
    public int min(int x,int y,int z){
        
        return Math.min(Math.min(x,y),z);
        
    }

}


