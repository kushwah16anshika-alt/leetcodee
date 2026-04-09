class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
       char [] ch = p.toCharArray();
       Arrays.sort(ch);
       for(int i=0;i<=s.length()-p.length();i++)
       {
        String str = s.substring(i,i+p.length());
        char [] temp = str.toCharArray();
        Arrays.sort(temp);
        if(Arrays.equals(temp,ch))
        {
            list.add(i);
        }
       }
       return list;
        
    }
}