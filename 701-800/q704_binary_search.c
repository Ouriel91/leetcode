// =========== 1 solutions =============

/*accepted*/
int search(int* nums, int numsSize, int target)
{

    int start = 0;
    int end = numsSize - 1;
    
    while(start <= end)
    {
        int middle = start + (end -start) / 2;
        
        if (target == nums[middle])
        {
            return middle;
        }
        else if(target > nums[middle])
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