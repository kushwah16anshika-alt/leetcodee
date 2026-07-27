class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2)
    {
        HashMap<Integer,ArrayList<Integer>>adj1=buildadj(edges1);
        HashMap<Integer,ArrayList<Integer>>adj2=buildadj(edges2);

        int d1=finddia(adj1);
        int d2=finddia(adj2);

        int combined=(d1 + 1 ) / 2+ (d2 + 1) / 2 + 1;

        return Math.max(Math.max(d1,d2),combined);
    }

    private HashMap<Integer,ArrayList<Integer>>buildadj(int [][]edges)
    {
        HashMap<Integer,ArrayList<Integer>>adj=new HashMap<>();

        for(int []edge:edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        return adj;
    }

    private int finddia(HashMap<Integer,ArrayList<Integer>>adj)
    {
        int [] first = bfs(adj,0);
        int farthest=first[0];

        int []second=bfs(adj,farthest);

        return second[1];
    }

     private int[] bfs(HashMap<Integer,ArrayList<Integer>>adj,int source)
     {
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(source);

        HashSet<Integer>visited = new HashSet<>();
        visited.add(source);

        int distance=0;

        int farnode=source;

        while(!queue.isEmpty())
        {
            int size =queue.size();

            while(size-->0)
            {
                int curr=queue.poll();
                farnode=curr;

                if(!adj.containsKey(curr))
                {
                    continue;
                }
                for(int nbr:adj.get(curr))
                {

                    if(!visited.contains(nbr))
                    {
                        visited.add(nbr);
                        queue.offer(nbr);
                    }
                }
            }
            if(!queue.isEmpty())
            {
                distance++;
            }
        }
        return new int []{farnode,distance};
     }
}