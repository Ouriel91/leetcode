// =========== 1 solutions =============

class Solution {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int middle = start + (end -start) / 2;

            if (target == arr[middle])
            {
                return middle;
            }
            else if(target > arr[middle])
            {
                start = middle + 1;
            }
            else
            {
                end = middle - 1;
            }
        }

        return -1;  
    }
}