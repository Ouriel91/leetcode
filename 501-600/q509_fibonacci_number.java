// =========== 4 solutions =============

//recusive solution, but less efficient (calculate sub recursions that wa calculate before)
class Solution {
    public int fib(int n) {
        if(0 == n)
        {
            return 0;
        }
        
        if(1 == n)
        {
            return 1;
        }
        
        return fib(n-1) + fib(n-2);
    }
}

//memoization - dynamic programming solution - bottom up approach
//using with kind of dictionary to avoid re calculating - improve recusive solution
class Solution {
    public int fib(int n) {
        
        if(1 >= n)
        {
            return n;
        }
        
        int [] dict = new int[n+1];
        dict[1] = 1;
        
        for(int i=2;i<=n;++i)
        {
            dict[i] = dict[i-1] + dict[i-2];
        }
        
        return dict[n];
    }
}

//iterative solution, more efficient 
class Solution {
    public int fib(int n) {
        
        int temp = 0;
        int first = 0;
        int second = 1;
        
        if(0 == n)
        {
            return 0;
        }
        
        for(int i = 2; i<=n;++i)
        {
            temp = first+second;
            first = second;
            second = temp;
        }
        
        return second;
    }
}

//mathematical solution - Binet formula
class Solution {
    public int fib(int n) {

        double phi = (1 + Math.sqrt(5))/2; //golden number phi
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n))/Math.sqrt(5));

        return nthTerm;
    }
}