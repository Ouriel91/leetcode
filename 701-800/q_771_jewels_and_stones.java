// =========== 2 solutions =============

//set solution
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int res = 0;       
        Set set = new HashSet();
        
        for(char j : jewels.toCharArray())
        {
            set.add(j);
        }
        
        for(char s: stones.toCharArray())
        {
            if(set.contains(s))
            {
                ++res;
            }
        }
        
        return res;
    }
}

//count array solution
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int []c_arr = new int[128]; //ascii values
        int res = 0;
        
        for(char s: stones.toCharArray())
        {
            c_arr[s]++;
        }
        
        for(char j : jewels.toCharArray())
        {
            res += c_arr[j];
        }
        
        return res;
    }
}
