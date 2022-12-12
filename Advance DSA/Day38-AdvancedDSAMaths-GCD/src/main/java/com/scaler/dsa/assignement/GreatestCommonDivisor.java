package com.scaler.dsa.assignement;


public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
}

/*Q3. Greatest Common Divisor
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given 2 non-negative integers A and B, find gcd(A, B)

GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.

Note: DO NOT USE LIBRARY FUNCTIONS.



Problem Constraints
0 <= A, B <= 109



Input Format
First argument is an integer A.
Second argument is an integer B.



Output Format
Return an integer denoting the gcd(A, B).



Example Input
Input 1:

A = 4
B = 6
Input 2:

A = 6
B = 7


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 2 divides both 4 and 6
Explanation 2:

 1 divides both 6 and 7
*/

/*Let's say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

           = gcd(m - 2n, n) if m >= 2n
           = gcd(m - 3n, n) if m >= 3n
             .
             .
             .
           = gcd(m - k*n, n) if m >= k*n

       In other words, we keep subtracting n till the result is greater than 0. Ultimately we will end up with m % n.

              So gcd(m, n)  = gcd(m % n, n)
*/