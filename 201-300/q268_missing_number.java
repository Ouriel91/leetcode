// =========== 1 solutions =============

class Solution {
    public int missingNumber(int[] arr) {
        
        int n_sum = arr.length * (arr.length +1) / 2;
        int actual_sum = 0;
        
        for(int i=0; i<arr.length; ++i)
        {
            actual_sum += arr[i];
        }
        
        return n_sum - actual_sum;
    }
}