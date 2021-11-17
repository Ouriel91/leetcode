// =========== 2 solutions =============

//simple approach
bool isPowerOfTwo(int n){

    long start = 1;//restriction of presentation
    
    if(0 >= n)
    {
        return false;
    }
    
    while(start < n)
    {
        start *= 2;
    }
    
    return start == n;
}

//more readable approach
bool isPowerOfTwo(int n){

    if (n < 1) {
        return false;
    }

    for (;0 == n % 2; n/=2) {
     /*empty loop*/   
    }
    return n == 1;
}