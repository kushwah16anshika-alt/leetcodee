class Solution 
{
    public int bagOfTokensScore(int[] tokens, int power) 
    {
        int n=tokens.length;
        Arrays.sort(tokens);

        int currs=0;
        int maxs=0;

        int l=0,r=n-1;

        while(l<=r)
        {
            if(power>=tokens[l])
            {
                currs++;
                maxs=Math.max(maxs,currs);
                power-=tokens[l];
                l++;
            }
            else if(currs>=1)
            {
                currs--;
                power+=tokens[r];
                r--;
            }
            else
            {
               return maxs;
            }
        }
         return maxs;
    }
}