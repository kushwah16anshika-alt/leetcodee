class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int [] time:times)
        {
            int u=time[0];
            int v=time[1];
            int w=time[2];
            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        int result[]=new int [n+1];
        for(int i=0;i<=n;i++)
        {
            result[i]=Integer.MAX_VALUE;
        }

        result[k]=0;

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty())
        {
            int [] curr=pq.poll();
            int d=curr[0];
            int node=curr[1];
            
             if(d > result[node])
                continue;

            for(int []vec:adj.get(node))
            {
                int adjnode=vec[0];
                int dist=vec[1];
   
                if(d+dist<result[adjnode])
                {
                   result[adjnode]=d+dist;
                   pq.offer(new int []{d+dist,adjnode});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            if(result[i]==Integer.MAX_VALUE)return -1;

            ans=Math.max(ans,result[i]);
        }
        return ans;
    }
}