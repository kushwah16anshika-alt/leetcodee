class Solution 
{
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int max=0;
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<s.length;j++)
            {
               if(g[i]<=s[j])
               {
                max++;
                s[j]=-1;
                break;
               }
            }
        }
        return max;
    }
}