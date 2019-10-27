/*

Maximum Sum
You are given an array A of N integers and three integers X, Y, and Z. You have to find the maximum value of A[i]*X + A[j]*Y + A[k]*Z, where 1 <= i <= j <= k <= N. Input Format
1st argument is an array A
2nd argument is an integer X
3rd argument is an integer Y
4th argument is an integer Z
Output Format
Return an Integer S, i.e maximum value of (A[i]*X + A[j]*Y + A[k]*Z), where  1 <= i <= j <= k <= N.
Constraints
1 <= N <= 1e5
-1e4 <= A[i], X, Y, Z <= 1e4
For Example
Input:
    A = [1, 5, -3, 4, -2]
    X = 2
    Y = 1
    Z = -1
Output:
    18

Explanation:
    if you choose i = 2, j = 2, and k = 3 then we will get
    A[2]*X + A[2]*Y + A[3]*Z = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18

*/


