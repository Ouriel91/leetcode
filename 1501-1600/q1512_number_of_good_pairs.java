// =========== 2 solutions =============

//naive approach

class Solution {
    public int numIdenticalPairs(int[] nums) {
       int count = 0;
        
        for(int i = 0; i<nums.length; ++i)
        {
            for(int j = i+1; j<nums.length; ++j) //i+1 to not check i<j
            {
                if(nums[i] == nums[j])
                {
                    ++count;
                }
            }
        }
        
        return count;
    }
}

//counter array solution
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int [] count_arr = new int[101]; //101 - constrains. in addition array of 0 in init
        
        for(int i = 0; i<nums.length; ++i)
        {
            res += count_arr[nums[i]]++;
        }
        
        return res;
    }
}