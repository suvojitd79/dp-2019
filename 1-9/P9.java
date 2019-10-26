/*
	
	Minimum Number of Squares	


*/




import java.util.*;
public class P9{

	public static void main(String[] args){

		System.out.println(minsquare(10));


	}

	public static int minsquare(int n){

		if(n<=3) return n;

		int[] cache= new int[n+1];
		cache[0] = 0;
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 3;

		for(int i=3;i<=n;i++){

			cache[i] = i;

			for(int j=1;j<=Math.ceil(Math.sqrt(i));j++){

				int temp = j * j;

				if(temp > i) break;

				else cache[i] = Math.min(cache[i], 1 + cache[i-temp]);

			}

		}

		return cache[n];

	}	


}


