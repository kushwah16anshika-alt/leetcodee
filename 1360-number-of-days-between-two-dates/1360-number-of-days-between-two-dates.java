class Solution 
{
    public int daysBetweenDates(String date1, String date2) 
    {
        return Math.abs(countdays(date1) - countdays(date2));

    }
    public int countdays(String date)
    {
        String []parts=date.split("-");
         int year=Integer.parseInt(parts[0]);
         int month=Integer.parseInt(parts[1]);
         int day=Integer.parseInt(parts[2]);

         int [] daysinmonth={31,28,31,30,31,30,31,31,30,31,30,31};

         int totalDays=(year-1)*365;

         totalDays+=(year -1)/4;
         totalDays-=(year-1)/100;
         totalDays+=(year-1)/400;

         for(int i=0;i<month-1;i++)
         {
            totalDays+=daysinmonth[i];
         }
         if(month>2 && ((year%4==0 && year%100 !=0 ||year%400==0)))
         {
            totalDays++;
         }
         totalDays+=day;

       return totalDays;

    }
}