// =========== 3 solutions =============

//naive approach
//Loop through all bits in an integer, check if a bit is set and if it is, then increment the set bit count.
int hammingWeight(uint32_t n) {
    
    int count = 0;
    
    for(; n!= 0; n >>= 1)
    {
        count += n&1;
    }
    
    return count;
}

//Brian Kernighan algorithm
//More optimized solution, no. of iteration will be equal to no. of set bits
//Subtracting 1 from a decimal number 
//flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit. 
int hammingWeight(uint32_t n) {
    
    int count = 0;
    
    for(; n!= 0; n &= (n-1))
    {
        ++count;
    }
    
    return count;
}


int hammingWeight(uint32_t i) {
    
     // C or C++: use uint32_t
     i = i - ((i >> 1) & 0x55555555);        // add pairs of bits
     i = (i & 0x33333333) + ((i >> 2) & 0x33333333);  // quads
     i = (i + (i >> 4)) & 0x0F0F0F0F;        // groups of 8
     return (i * 0x01010101) >> 24;          // horizontal sum of bytes
}