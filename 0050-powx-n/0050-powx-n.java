class Solution {
    public double myPow(double x, int n) 
    {
        long N=n;
        if(n<0)
        {
            x=1/x;
            N=-N;
        }
        return FastPow(x,N);
    }
    private double FastPow(double x,long n)
    {
        if(n==0)
        {
            return 1.0;
        }
        double half=FastPow(x,n/2);

        if(n%2==0)
        {
            return half*half;
        }
        return half*half*x;
    }
}