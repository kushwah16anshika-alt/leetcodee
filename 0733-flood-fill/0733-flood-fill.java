class Solution 
{
    int N, M;
    int originalColor;
    void dfs(int[][] image, int row, int col, int color)
    {
        if(row<0 || row>=N || col<0 || col>=M)
        {
            return;
        }
        if(image[row][col]!=originalColor)
        {
            return;
        }
       
        image[row][col]=color;

        dfs(image,row+1,col, color);
        dfs(image,row-1,col, color);
        dfs(image,row,col+1, color);
        dfs(image,row,col-1, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        N=image.length;
        M=image[0].length;

        originalColor=image[sr][sc];

        if(originalColor==color)
        {
            return image;
        }
        dfs(image,sr,sc,color);
       
       return image;
    }
}