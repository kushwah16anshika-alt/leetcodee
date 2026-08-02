class Solution 
{
    public String longestPalindrome(String s) 
    {
        int n=s.length();

        if(n<=1)
        {
            return s;
        }
        boolean[][]dp=new boolean[n][n];

        int start=0;
        int maxlen=1;

         for (int i = n - 1; i >= 0; i--)
          {

            for (int j = i; j < n; j++)
             {
               if(s.charAt(i)==s.charAt(j))
               {
                if(j-i<=2 || dp[i+1][j-1])
                {
                    dp[i][j]=true;

                    if(j-i+1>maxlen)
                    {
                        start=i;
                        maxlen=j-i+1;
                    }
                }
               }
             }

          }
       return s.substring(start,start+maxlen);
    }
}