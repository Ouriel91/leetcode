// =========== 1 solutions =============

class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i<n; ++i)
        {
            if((0 == (i+1)%3) && (0 == (i+1) %5))
            {
                list.add("FizzBuzz");
            }
            else if(0 == (i+1)%5)
            {
                list.add("Buzz");
            }
            else if(0 == (i+1)%3)
            {
                list.add("Fizz");
            }
            else
            {
                list.add(String.valueOf(i+1));
            }
        }
        
        return list;
    }
}