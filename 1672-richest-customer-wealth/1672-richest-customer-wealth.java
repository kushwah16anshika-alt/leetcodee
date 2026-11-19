class Solution 
{
    public int maximumWealth(int[][] accounts) 
    {
        int row=accounts.length;
        int max =0;
        for(int i=0;i<row;i++)
        {
            int sum=0;
             for(int j=0;j<accounts[i].length;j++)
             {
                sum += accounts[i][j];
             }
             max = Math.max(max, sum);
        }

        return max;
    }
}