// =========== 4 solutions =============

//naive solution
class Solution {
    public int countKDifference(int[] arr, int k) {
        int count = 0;
        
        for(int i = 0; i<arr.length;++i)
        {
            for(int j=i+1; j<arr.length;++j)
            {
                if(k == Math.abs(arr[i] - arr[j]))
                {
                    ++count;
                }
            }
        }
        
        return count;
    }
}

//sort solution
class Solution {
    public int countKDifference(int[] arr, int k) {
        int count = 0;
        
        Arrays.sort(arr);
        
        int start = 0, end = arr.length - 1;
        
        while(start < end)
        {
            if(k == arr[end] - arr[start])
            {
                ++count;
                ++start;
            }
            
            if(k < arr[end] - arr[start])
            {
                ++start;
            }
            
            if(k > arr[end] - arr[start])
            {
                --end;
                start = 0; //start from begin again
            }
        }
        
        return count;
    }
}

//map solution
class Solution {
    public int countKDifference(int[] arr, int k) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length; ++i)
        {
            // provide key whose value has to be obtained
            // and default value for the key
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            count += map.getOrDefault(arr[i] - k, 0) + map.getOrDefault(arr[i] + k, 0); 
        }
        
        return count;
    }
}

//counting sort solution
class Solution {
    public int countKDifference(int[] arr, int k) {
        
        int count = 0;
        int []count_arr = new int[201];//constrains
        
        for(int i = 0; i<arr.length; ++i)
        {
            count_arr[arr[i]]++;
        }
        
        for(int i = 0; i<arr.length; ++i)
        {
            count += count_arr[arr[i]+k];
        }
        
        return count;
    }
}