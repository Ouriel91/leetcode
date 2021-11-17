// =========== 2 solutions =============

//Kadane’s algorithm - look for all positive contiguous segments of the array (max_temp)
//keep track of maximum sum contiguous segment among all positive segments (max). 
//Each time we get a positive-sum compare it with max_temp and update max 
//if it is greater than max_temp 
class Solution {
    public int maxSubArray(int[] arr) {
        
        int max = Integer.MIN_VALUE, max_temp = 0;
        
        for(int i = 0; i<arr.length; ++i)
        {
            max_temp += arr[i];
            
            if(max < max_temp)
            {
                max = max_temp;    
            }
            if(max_temp < 0)
            {
                max_temp = 0;
            }
        }
        
        return max;
    }
}

//Dynamic programing solution
class Solution {
    public int maxSubArray(int[] arr) {
        
        int []helper = new int[arr.length];
        
        helper[0] = arr[0];
        int max = helper[0];
        
        for(int i = 1; i<arr.length; ++i)
        {
            helper[i] = arr[i] + (helper[i-1] > 0 ? helper[i-1] : 0);
            
            max = Math.max(helper[i], max);
        }
        
        return max;
    }
}