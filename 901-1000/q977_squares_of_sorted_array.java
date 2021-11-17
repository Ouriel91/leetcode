// =========== 2 solutions =============

//naive approach
class Solution {
    public int[] sortedSquares(int[] arr) {
       for(int i=0; i<arr.length; ++i)
        {
            arr[i] *= arr[i];
        }
        
        Arrays.sort(arr);
        
        return arr;
    }
}

//two indexes approach
class Solution {
    public int[] sortedSquares(int[] arr) {
       int[] ret = new int[arr.length];
        int start = 0, end = arr.length - 1, index = arr.length -1;
        
        while(start <= end)
        {
            int start_square = arr[start] * arr[start];
            int end_square = arr[end] *arr[end];
            
            if(start_square < end_square)
            {
                ret[index] = end_square;
                --end;
            }
            else
            {
                ret[index] = start_square;
                ++start;
            }
            --index;
        }
        
        
        return ret;
    }
}