// =========== 1 solutions =============

//naive approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        
        for(int i = 0; i<nums.length;++i)
        {
            for(int j = i+1; j<nums.length;++j)
            {
                if(target == nums[i] + nums[j])
                {
                    res[0] = i;
                    res[1] = j;
                    
                    return res;
                }
            }
        }
        
        return res;
    }
}

//hash table approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; ++i)
        {
            if(map.containsKey(target - nums[i]))
            {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            //not exist in map, so map it
            map.put(nums[i], i);
        }
        
        return res;
    }
}