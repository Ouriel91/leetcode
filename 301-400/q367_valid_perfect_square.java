// =========== 3 solutions =============

//iterative solution find num that perfect square iterativly
//stop iteration when i*i bigger than num (not need to calculate anymore)
class Solution {
    public boolean isPerfectSquare(int num) {
      
        for(int i = 1; i<num+1 && i*i<=num; ++i) //n+1 for 1 that can enter to loop
        {
            if(num == i*i)
            {
                return true;
            }
        }
        
        return false;
    }
}

//iterative solution - mathematical
//A square number is 1+3+5+7+...
//o(sqrt(n))
class Solution {
    public boolean isPerfectSquare(int num) {
      
        int i = 1;
        
        while(0 < num)
        {
            num -= i;
            i+=2;
        }
        
        return 0 == num;
    }
}

//binary search solution
//we looking for the square so the best algorithem to search in ordered (acesending)
//things is binary search
class Solution {
    public boolean isPerfectSquare(int num) {
      
        long start = 1, end = num; //long for question restrictions
        
        while(start <= end)
        {
            long mid = (start + end) / 2; //long for question restrictions
            
            if(num == mid*mid)
            {
                return true;
            }
            else if(num > mid * mid)
            {
                start = mid + 1; 
            }
            else
            {
                end = mid - 1;
            }
        }
        
        return false;
    }
}