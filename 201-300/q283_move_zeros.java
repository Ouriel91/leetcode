// =========== 3 solutions =============

//naive approach but have the excercise requires
class Solution {
    public void moveZeroes(int[] arr) {
       
        for(int i=0; i<arr.length;++i)
        {
            for(int j = i+1; j<arr.length; ++j)
            {
                if(0 == arr[i] && 0 != arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

//with helper memory array - not stand in the excercise requierments 
//just help to reach the next Solution
class Solution {
    public void moveZeroes(int[] arr) {
       
        int [] temp = new int[arr.length];
        int start = 0, end = arr.length - 1;
        
        for(int i = 0; i<arr.length; ++i)
        {
            if(0 == arr[i])
            {
                temp[end] = arr[i];
                --end;
            }
            else
            {
                temp[start] = arr[i];
                ++start;
            }
        }
        
        for(int i = 0; i<arr.length; ++i)
        {
            arr[i] = temp[i];
        }
    }
}

//efficient solution - have the excercise requierments 
class Solution {
    public void moveZeroes(int[] arr) {
        int non_zero_index = 0;
        
        for(int i=0; i<arr.length; ++i)
        {
            if(0 != arr[i])
            {
                arr[non_zero_index++] = arr[i];
                /*
                //could by written:
                arr[non_zero_index] = arr[i];
                ++non_zero_index;
                */ 
            }
        }
        
        for(int i = non_zero_index; i<arr.length; ++i)
        {
            arr[i] = 0;
        }
    }
}