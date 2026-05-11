class Solution {
    public int diagonalSum(int[][] mat)
    {
       int sum= 0;
       for(int r=0;r<mat.length;r++)
       {
         for(int c=0;c<mat.length;c++)
         {
            if(r==c||r+c==mat.length-1)
            {
                sum+=mat[r][c];
            }
         } 
       }
        return sum;
    }
}