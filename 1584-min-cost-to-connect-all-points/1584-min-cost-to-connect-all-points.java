class Solution {
    public int minCostConnectPoints(int[][] points) 
    {
        int n=points.length;

        boolean visited[]=new boolean [n];
        int mindist[]=new int [n];

        Arrays.fill(mindist,Integer.MAX_VALUE);

        mindist[0]=0;
        int totalcost=0;

        for(int i=0;i<n;i++)
        {
            int u=-1;

             for(int j=0;j<n;j++)
              {
               if(visited[j]==false && (u==-1 || mindist[j]<mindist[u]))
               {
                 u = j;
               }
              }
           visited[u]=true;
           totalcost+=mindist[u];

           for(int v=0;v<n;v++)
           {
            if(visited[v]==false)
            {
                int distance=Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);

                 if(distance<mindist[v])
                 {
                    mindist[v]=distance;
                 }
            }

           
           }

        }

        return totalcost;
    }
}