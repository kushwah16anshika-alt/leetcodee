class Solution 
{
    int[] days = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public int getdays(String date)
    {
        int month=Integer.parseInt(date.substring(0,2));
        int day=Integer.parseInt(date.substring(3,5));

        int total=day;

        for(int i=0;i<month-1;i++)
        {
            total+=days[i];
        }
      return total;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) 
    {
        int a1=getdays(arriveAlice);
        int a2=getdays(leaveAlice);
        int b1=getdays(arriveBob);
        int b2=getdays(leaveBob);

        int start=Math.max(a1,b1);
        int end=Math.min(a2,b2);
        
         if (start > end) 
         {
            return 0;
         }

        return end-start+1;

    }
}