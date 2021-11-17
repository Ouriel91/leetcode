// =========== 1 solutions =============

void reverseString(char* s, int n){

    int begin = 0;
    int end = n - 1;
    
    while(begin < end)
    {
        char temp = s[begin];
        s[begin] = s[end];
        s[end] = temp;
        
        ++begin;
        --end;
    }
}