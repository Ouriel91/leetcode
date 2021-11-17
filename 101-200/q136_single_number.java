// =========== 2 solutions =============

//in xor 0^0^0 = 0, 1^1^1 = 1, 0^0^1 = 1, 1^1^0 = 0. 
//Thus, after the bit manipulation of XOR, the every bit of result is the bit of single number.
class Solution {
    public int singleNumber(int[] arr) {
        int xor = 0;
        
        for(int i = 0; i<arr.length; ++i)
        {
            xor ^= arr[i];
        }
        
        return xor;
    }
}

//using set for unique number
class Solution {
    public int singleNumber(int[] arr) {
        Set<Integer> s = new HashSet<Integer>();
	    for (int i: arr){
	    	if(!s.add(i)){
	    		s.remove(i);
	    	}
	    }
	    return s.iterator().next(); //get data
    }
}