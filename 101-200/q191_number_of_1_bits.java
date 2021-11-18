// =========== 2 solutions =============

//Brian Kernighan algorithm
//More optimized solution, no. of iteration will be equal to no. of set bits
//Subtracting 1 from a decimal number 
//flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit.
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
    
        for(; n!= 0; n &= (n-1))
        {
            ++count;
        }

        return count;
    }
}


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int i) {
        i = i - ((i >> 1) & 0x55555555);        // add pairs of bits
     i = (i & 0x33333333) + ((i >> 2) & 0x33333333);  // quads
     i = (i + (i >> 4)) & 0x0F0F0F0F;        // groups of 8
     return (i * 0x01010101) >> 24;          // horizontal sum of bytes
    }
}
