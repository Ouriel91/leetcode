// =========== 2 solutions =============

//simple approach
class Solution {
    public boolean isPowerOfThree(int n) {
        long start = 1;//restriction of presentation

        if(0 >= n)
        {
            return false;
        }

        while(start < n)
        {
            start *= 3;
        }

        return start == n;
    }
}

//more readable approach
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        for (;0 == n % 3; n/=3) {
         /*empty loop*/   
        }
        return n == 1;
    }
}

