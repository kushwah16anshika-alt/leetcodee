class Solution 
{
    public String shortestCompletingWord(String licensePlate, String[] words) 
    {

        int[] freq = new int[26];

        for (char ch : licensePlate.toLowerCase().toCharArray()) 
        {
            if (ch >= 'a' && ch <= 'z') 
            {
                freq[ch - 'a']++;
            }
        }

        String ans = "";

        for (String word : words) 
        {

            int[] count = new int[26];

            for (char ch : word.toCharArray()) 
            {
                count[ch - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] < freq[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid && (ans.equals("") || word.length() < ans.length())) 
            {
                ans = word;
            }
        }

        return ans;
    }
}