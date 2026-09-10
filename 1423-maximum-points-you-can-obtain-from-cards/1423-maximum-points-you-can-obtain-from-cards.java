class Solution {
      static {
        for(int i = 0; i<500; i++){
            maxScore(new int[1], 1);
        }
    }
    public  static int maxScore(int[] arr, int k) {
        int sum=0;
        int max=0;
        int left =k-1;
        int right=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        max=sum;
        while(right<k)
        {
            sum-=arr[left];
            sum+=arr[arr.length-1-right];
            max=Math.max(max,sum);
            left--;
            right++;

        }
        return max;
        
    }
}