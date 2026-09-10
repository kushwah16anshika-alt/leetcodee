class Solution 
{
    public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;
        int total = 0;

        for(int i = 0; i < n; i++)
        {
            total += cardPoints[i];
        }

        int size = n - k;
        int sum = 0;

        for(int i = 0; i < size; i++)
        {
            sum += cardPoints[i];
        }

        int min = sum;

        for(int i = size; i < n; i++)
        {
            sum += cardPoints[i];
            sum -= cardPoints[i - size];

            min = Math.min(min, sum);
        }

        return total - min;
    }
}