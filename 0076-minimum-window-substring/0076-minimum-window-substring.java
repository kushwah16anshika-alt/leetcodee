class Solution 
{
    public String minWindow(String s, String t) 
    {
        int n=s.length();

        if(t.length()>n)
        {
            return "";
        }

        Map<Character,Integer>mp=new HashMap<>();

        for(char ch:t.toCharArray())
         mp.put(ch,mp.getOrDefault(ch,0)+1);

         int reqcount=t.length();
         int i=0,j=0;

         int minwindowsize=Integer.MAX_VALUE;
         int start_i=0;

         while(j<n)
         {
            char ch = s.charAt(j);

            if(mp.containsKey(ch) && mp.get(ch)>0)
            {
                reqcount--;
            }

            mp.put(ch,mp.getOrDefault(ch,0)-1);

            while(reqcount==0)
            {
                int currwindowsize=j-i+1;

                if(minwindowsize > currwindowsize)
                {
                    minwindowsize = currwindowsize;
                    start_i=i;
                }

                char startchar=s.charAt(i);
                mp.put(startchar,mp.getOrDefault(startchar,0)+1);

                if(mp.containsKey(startchar) && mp.get(startchar)>0)
                {
                    reqcount++;
                }
                i++;
            }
            j++;
         }

        return minwindowsize == Integer.MAX_VALUE ? "" :s.substring(start_i,start_i+minwindowsize);
    }
}