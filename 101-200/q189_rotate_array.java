// =========== 3 solutions =============

//pass except one
class Solution {
    public void rotate(int[] arr, int k) {
        for(int i = 0; i<k; ++i)
        {
            int last = arr[arr.length -1];
            for(int j = arr.length-1; j>=1; --j)
            {
                arr[j] = arr[j-1];
            }
            
            arr[0] = last;
        }
    }
}

//with another memory
class Solution {
    public void rotate(int[] arr, int k) {
        int [] temp = new int[arr.length];
        
        for(int i=0; i<arr.length;++i)
        {
            temp[(i+k)%(arr.length)] = arr[i];
        }
        
        for(int i=0; i<arr.length;++i)
        {
            arr[i] = temp[i];
        }
    }
}

//no memory - best
class Solution {
    
    public void swap(int []arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }
    
    public void rotate(int[] arr, int k) {
        k %= arr.length;
        
        swap(arr, 0 ,arr.length - 1);
        swap(arr, 0, k-1);
        swap(arr, k, arr.length -1);
    }
}