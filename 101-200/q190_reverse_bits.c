// =========== 2 solutions =============

//loop solution
uint32_t reverseBits(uint32_t num) {
    unsigned int  bits_num = sizeof(num) * 8 - 1;
    unsigned int res = num;
  
    num >>= 1; //first iteration
    //keep putting set bits of the num in reverse_num until num becomes zero. 
    //After num becomes zero, shift the remaining bits of reverse_num.
    for (; 0 != num; num >>= 1, --bits_num)
    {
        res <<= 1;
        res |= (num & 1);
    }
    
    res <<= bits_num;//shift iterations left
   
    return res;
}

//o(1) solution
uint32_t reverseBits(uint32_t num) {
    num = (num >> 16) | (num << 16);
    num = ((num & 0xff00ff00) >> 8) | ((num & 0x00ff00ff) << 8);
    num = ((num & 0xf0f0f0f0) >> 4) | ((num & 0x0f0f0f0f) << 4);
    num = ((num & 0xcccccccc) >> 2) | ((num & 0x33333333) << 2);
    num = ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) <<1);
    
    return num;
}