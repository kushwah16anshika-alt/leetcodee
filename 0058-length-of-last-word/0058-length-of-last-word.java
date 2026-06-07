class Solution 
{
    public int lengthOfLastWord(String s) 
    {
        String []parts=s.split(" ");
        String lastword=parts[parts.length-1];
        return lastword.length();
    }
}