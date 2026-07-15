class Solution {

    int rows, cols, len;

    int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        len = word.length();

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(dfs(board,i,j,word,0))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,int i,int j,String word,int index)
    {

        if(index == len)
            return true;

        if(i<0 || i>=rows || j<0 || j>=cols ||
           board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] dir : directions)
        {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if(dfs(board,newRow,newCol,word,index+1))
            {
                board[i][j] = temp;   // Restore before returning
                return true;
            }
        }

        board[i][j] = temp;   // Backtrack

        return false;
    }
}