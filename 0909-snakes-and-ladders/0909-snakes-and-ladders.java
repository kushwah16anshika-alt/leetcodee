class Solution 
{
    int n;
    public int snakesAndLadders(int[][] board) 
    {
        n=board.length;

        Queue<Integer>q=new LinkedList<>();
        boolean[][]visited=new boolean[n][n];

        q.offer(1);
        visited[n-1][0]=true;

        int moves=0;

        while(!q.isEmpty())
        {
            int size=q.size();

            while(size-->0)
            {
                int current=q.poll();

                if(current==n*n)
                {
                    return moves;
                }

                for(int dice=1;dice<=6;dice++)
                {
                    int nxt=current+dice;

                    if(nxt>n*n)
                    {
                        break;
                    }
                    int []pos=getcoord(nxt);

                    int row=pos[0];
                    int col=pos[1];

                    if(visited[row][col])
                    {
                        continue;
                    }

                    visited[row][col]=true;

                    if(board[row][col]!=-1)
                    {
                        q.offer(board[row][col]);
                    }else
                    {
                        q.offer(nxt);
                    }
                }
            }
         moves++;
        }
        return -1;
    }
    public int [] getcoord(int cell)
    {
        int row=n-1-(cell-1)/n;
        int col=(cell-1)%n;

        if((n%2==0 && row%2==0) || (n%2==1 && row%2==1))
        {
            col=n-1-col;
        }
        return new int[]{row,col};
    }
}