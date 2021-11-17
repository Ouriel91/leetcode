// =========== 1 solutions =============

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