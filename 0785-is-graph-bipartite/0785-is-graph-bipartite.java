class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int v=graph.length;
        int []color=new int[v];
        Arrays.fill(color,-1);

        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(graph,i,color,1))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph,int curr,int color[],int currcolor)
    {
        color[curr]=currcolor;
        for(int u:graph[curr])
        {
            if(color[u]==color[curr])
            {
                return false;

            }
            if(color[u]==-1)
            {
                int colorofv=1-currcolor;

                if(!dfs(graph,u,color,colorofv))
                {
                    return false;
                }
            }
        }

        return true;
    }
}