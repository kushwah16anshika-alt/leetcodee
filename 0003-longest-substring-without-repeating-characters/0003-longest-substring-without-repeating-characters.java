class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int[] freq = new int[256];

        int i = 0;
        int maxLen = 0;

        for(int j = 0; j < s.length(); j++)
        {
            char ch = s.charAt(j);

            freq[ch]++;

            while(freq[ch] > 1)
            {
                freq[s.charAt(i)]--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}