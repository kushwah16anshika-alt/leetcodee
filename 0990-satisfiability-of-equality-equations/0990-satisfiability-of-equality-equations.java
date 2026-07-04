class Solution 
{
    int []parent;
        int []rank;
        public int find(int i)
        {
            if(parent[i]!=i)
            {
                parent[i]=find(parent[i]);
            }
            
                return parent[i];
        }

        public void union(int x,int y)
        {
            int px=find(x);
            int py=find(y);

            if(px!=py)
            {
                if(rank[px]>rank[py])
                {
                    parent[py]=px;
                }else if(rank[py]>rank[px])
                {
                  parent[px]=py;
                }
                else {
                    parent[px]=py;
                    rank[py]++;
                }
            }
        }
    public boolean equationsPossible(String[] equations) 
    {
         parent = new int[26];
         rank = new int[26];

        for(int i=0;i<26;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
         for (String s : equations) 
         {
            if (s.charAt(1) == '=') 
            {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for(String s:equations)
        {
            if(s.charAt(1)=='!')
            {
                if(find(s.charAt(0)-'a')==find(s.charAt(3)-'a'))
                {
                    return false;
                }
            }
        }
        return true;
    }
}