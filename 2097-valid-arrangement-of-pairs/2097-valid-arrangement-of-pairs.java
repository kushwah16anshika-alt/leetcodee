class Solution 
{
    public int[][] validArrangement(int[][] pairs) 
    {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer,Integer> outdegree = new HashMap<>();

        for(int [] edge : pairs)
        {
            int u = edge[0];
            int v = edge[1];


            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(v);

            outdegree.put(u,outdegree.getOrDefault(u,0)+1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }
        int  startnode = pairs[0][0];

        for(int node : adj.keySet())
        {
            if(outdegree.getOrDefault(node,0)-indegree.getOrDefault(node,0)==1)
            {
                startnode = node;
                break;
            }
        }
        Stack<Integer>st = new Stack<>();
        ArrayList<Integer> eulerpath = new ArrayList<>();

        st.push(startnode);

        while(!st.isEmpty())
        {
            int curr = st.peek();

            if(!adj.get(curr).isEmpty())
            {
                ArrayList<Integer> list = adj.get(curr);
                int next=list.remove(list.size()-1);
                st.push(next);

            }
            else
            {
                eulerpath.add(curr);
                st.pop();
            }
        }
        Collections.reverse(eulerpath);

        int [][] result = new int[pairs.length][2];
        for(int i=0;i<pairs.length;i++)
        {
          result[i][0] = eulerpath.get(i);
          result[i][1]=eulerpath.get(i+1); 
        }
        return result;
    }

}