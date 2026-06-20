class Solution
{
    public String convert(String s, int numRows)
    {
        if(numRows == 1 || numRows >= s.length())
        {
            return s;
        }

        String[] arr = new String[numRows];

        for(int i = 0; i < numRows; i++)
        {
            arr[i] = "";
        }

        int i = 0;

        while(i < s.length())
        {
            // Downward
            for(int row = 0; row < numRows && i < s.length(); row++)
            {
                arr[row] += s.charAt(i++);
            }

            // Diagonal Upward
            for(int row = numRows - 2; row > 0 && i < s.length(); row--)
            {
                arr[row] += s.charAt(i++);
            }
        }

        String res = "";

        for(String str : arr)
        {
            res += str;
        }

        return res;
    }
}