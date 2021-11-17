// =========== 2 solutions =============

//simple approach
bool isPowerOfFour(int n){

    long start = 1;//restriction of presentation
    
    if(0 >= n)
    {
        return false;
    }
    
    while(start < n)
    {
        start *= 4;
    }
    
    return start == n;
}

//more readable approach
bool bool isPowerOfFour(int n){
(int n){

    if (n < 1) {
        return false;
    }

    for (;0 == n % 4; n/=4) {
     /*empty loop*/   
    }
    return n == 1;
}