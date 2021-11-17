// =========== 1 solutions =============

//passes 301/305 test cases (the reason is constrains probably)
double myPow(double x, int n){

    double ret = 1;
    
    //1 pow everything is 1
    if(1 == x)
    {
        return 1;
    }
    
    if(0 > n)
    {
        x = 1/x;
        n *= -1;
    }
    
    while(n > 0)
    {
        ret *= x;
        --n;
    }
    
    return ret;
}