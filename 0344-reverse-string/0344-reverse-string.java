class Solution 
{
    public void reverseString(char[] s) 
    {
        String str = new String(s);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        char[] arr = sb.toString().toCharArray();

        for(int i = 0; i < s.length; i++)
        {
            s[i] = arr[i];
        }
    }
}