/* 

	Longest Balanced Substring

	Given a string S made up of multiple brackets of type "<>" , "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string . Conditions for a string to be balanced : 1) Blank string is balanced ( However blank string will not be provided as a test case ). 2) if B is balanced : (B) , [B] , {B} and <B> are also balanced. 3) if B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced. Your function will get exactly one argument which would represent the string S. Your function should return an integer corresponding to the answer. Constraints :
	0 <= length(S) <= 1000000
	Sample Test Case :
	Input : <<<<>
	Output : 2 


*/

import java.util.*;
public class P13{


	public boolean isValid(char x, char y){


		HashMap<Character,Character> map = new HashMap();
		map.put('(',')');
		map.put('<','>');
		map.put('{','}');
		map.put('[',']');	


		if(x == '(' && map.get(x) == y) return true;
		else if(x == '<' && map.get(x) == y) return true;
		else if(x == '{' && map.get(x) == y) return true;
		else if(x == '[' && map.get(x) == y) return true;
		else return false;
	}


	// O(n) solution
	public int longestValidParentheses(String A) {
        
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList();
        stack.addLast(-1);
        
        for(int i=0;i<A.length();i++){
            
            if(A.charAt(i) == '(' || A.charAt(i) == '{' || A.charAt(i) == '[' || A.charAt(i) == '<')
                stack.addLast(i);
            else{
            	int x = stack.pollLast();
                if(!stack.isEmpty() && x != -1 && isValid( A.charAt(x), A.charAt(i)))
                    ans = Math.max(ans, i - stack.peekLast());
                
                else stack.addLast(i);
            }
            
        }
        return ans;
    }


	public static void main(String... args){

		System.out.println(new P13().longestValidParentheses("[]{}<{>"));
		
	}
}