/* 
	Min number of squares required that sums to n
*/

import java.util.*;
public class P14{

	public int solve(int n){

		if((n & (n-1)) == 0) return 1;

		else if(n <= 3) return n;

		int[] cache = new int[n+1];

		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 3;

		for(int i=4;i<=n;i++){

			cache[i] = i;

			for(int j = 1;j<= Math.ceil(Math.sqrt(i));j++){
				int temp = j * j;
				if( temp > i) break;
				cache[i] = Math.min(cache[i], 1 + cache[i-temp]);
			}

		}
		return cache[n];

	}


	public static void main(String... args){

		System.out.println(new P14().solve(10));

	}

}