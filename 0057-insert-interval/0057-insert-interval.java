class Solution 
{
    public int[][] insert(int[][] intervals, int[] newinterval) 
    {
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        
        int start = newinterval[0];
        int end = newinterval[1];

        for (int i = 0; i < intervals.length; i++) 
        {

            int currstart = intervals[i][0];
            int currend = intervals[i][1];

           
            if (currstart <= end && currend >= start) {
                
                start=Math.min(start,currstart);
                end = Math.max(end, currend);
            }
           else {
                
                if(currend<start)
                {
                    list.add(intervals[i]);
                }
                
                else if(currstart>end)
                {
                    list.add(new int[]{start,end});
                    start = Integer.MAX_VALUE;
                    end = Integer.MIN_VALUE;
                    list.add(intervals[i]);
                }
               
               
            }

        }
       if (start != Integer.MAX_VALUE) 
       {
            list.add(new int[]{start, end});
        }
        
        return list.toArray(new int[list.size()][]);
    }
}