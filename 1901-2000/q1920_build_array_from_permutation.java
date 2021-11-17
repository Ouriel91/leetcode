// =========== 2 solutions =============

//iterative solution with extra memory - naive approach
class Solution {
    public int[] buildArray(int[] arr) { 
        int[] res = new int[arr.length];
        
        for(int i = 0; i<res.length;++i)
        {
            res[i] = arr[arr[i]];
        }
        
        return res;
    }
}

//iterative solution without extra memory
class Solution {
    public int[] buildArray(int[] arr) { 
        
        int n = arr.length;
        
        for(int i = 0; i<n;++i)
        {
            // this is done to keep both old and new value together. 
            // going by the example of [5,0,1,2,3,4]
            // after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
            // now for next index calulation 
            // we might need the original value of num[0] which can be obtain by num[0]%6 = 29%6 = 5;
            // if we want to get just he new value of num[0], we can get it by num[0]/6 = 29/6 = 4
            arr[i] += n*(arr[arr[i]] % n);

            //arr[i] = arr[i] + n*(arr[arr[i]] % n); //long version
        }
        
        for(int i=0; i<n; ++i)
        {
            //arr[i] = arr[i]/n; //long version
            arr[i] /= n;
        }
        
        return arr;
    }
}