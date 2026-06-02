class Solution 
{
    public int minCost(String colors, int[] neededTime)
    {
        
        char[] arr=colors.toCharArray();
        int n=neededTime.length;
        int time=0;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]==arr[i+1])
            {
               time += Math.min(neededTime[i],neededTime[i+1]);
               neededTime[i+1] = Math.max(neededTime[i],neededTime[i+1]);
            }
        }

        return time;
    }
}