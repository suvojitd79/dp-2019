/*
	Stairs


*/
import java.util.*;
public class P3{

	public int climbStairs(int A) {
    
        int[] cache = new int[A+1];     
        cache[0]=cache[1] = 1;
        for(int i=2;i<=A;i++)
            cache[i] = cache[i-1] + cache[i-2];
        return cache[A];
    }

}


