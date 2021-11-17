// =========== 1 solutions =============

//other idea from c file - accepted (refer to constrains)
class Solution {
    public double myPow(double x, int n) {
    if(0 == n)
    {
        return 1;
    }
    
    //constains
    if(n == Integer.MIN_VALUE){
        x *= x;
        n = n/2;
    }
    
    if(0 > n)
    {
        n = -n;
        x = 1/x;
    }
    
    return (0 == n%2) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}