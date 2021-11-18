// =========== 2 solutions =============

//using extra memory
class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int []res = new int[2*n];
                
        for(int i=0; i<n; ++i)
        {
           res[2*i] = nums[i];
           res[2*i+1]  = nums[i+n];
        }
        
        return res;
    }
}

//in place solution
//the basic idea like question 1920
//1024 is choosed, because the constrains is 10^3 (1024)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;
        
        for(int i = n; i<len; ++i)
        {
            nums[i] = (nums[i] * 1024) + nums[i-n];
        }
        
        int index = 0;
        for(int i = n; i<len; ++i, index += 2)
        {
            nums[index] = nums[i] % 1024;
            nums[index  + 1] = nums[i] / 1024; 
        }
        
        return nums;
    }
}