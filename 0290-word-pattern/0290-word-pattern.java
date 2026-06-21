class Solution {
    public boolean wordPattern(String pattern, String s) 
    {
        String []words=s.split(" ");

        if(pattern.length()!=words.length)
        {
            return false;
        }
        HashMap<Character, Integer> mapP = new HashMap<>();
        HashMap<String, Integer> mapW = new HashMap<>();

        for(int i=0;i<pattern.length();i++)
        {
            char ch=pattern.charAt(i);
            String word = words[i];

            if(!mapP.getOrDefault(ch,0).equals(mapW.getOrDefault(word,0)))
            {
                return false;
            }
            mapP.put(ch,i+1);
            mapW.put(word,i+1);
        }
        return true;
    }
}