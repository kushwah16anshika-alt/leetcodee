class Solution { 
    public double averageWaitingTime(int[][] nums)  
    { 
        int n = nums.length;

        long finish = 0;
        long sum = 0;

        for(int i = 0; i < n; i++) 
        { 
            int arrival = nums[i][0];

            finish = Math.max(finish, arrival);

            finish += nums[i][1];

            long waiting = finish - arrival;

            sum += waiting;
        }

        return (double) sum / n;
    } 
}