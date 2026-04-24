class Solution 
{
    public int dayOfYear(String date)
    {
        String []parts=date.split("-");
         int year=Integer.parseInt(parts[0]);
         int month=Integer.parseInt(parts[1]);
         int days=Integer.parseInt(parts[2]);

         int [] daysinmonth={31,28,31,30,31,30,31,31,30,31,30,31};

         int totaldays=0;

         if((year%4==0 && year%100!=0)||year%400==0)
         {
            daysinmonth[1]=29;
         }
         for(int i=0;i<month-1;i++)
         {
            totaldays+=daysinmonth[i];
         }
         totaldays+=days;

         return totaldays;
    }
}