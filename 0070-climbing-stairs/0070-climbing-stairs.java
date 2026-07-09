class Solution {
    public int climbStairs(int n) 
    {
         // Agar sirf 1 ya 2 stairs hain to direct answer return kar
        if(n<=2)return n;

        int a=1;
        int b=2;

        for(int i=3;i<=n;i++)
        {
            int temp=a+b;
            a=b;
            b=temp;
        }

        return b;
    }
}