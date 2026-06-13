class Solution 
{
    public List<String> findRepeatedDnaSequences(String s) 
    {
        List<String> ans = new ArrayList<>();

        if (s.length() < 10)
            return ans;

        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        long hash = 0;

        // Base for polynomial hashing
        long base = 5;

        // leftmost character remove karne ke liye
        long power = 1;

        for (int i = 0; i < 9; i++)
        {
            power *= base;
        }

        Set<Long> seen = new HashSet<>();

        Set<String> added = new HashSet<>();

        // First window hash
        for (int i = 0; i < 10; i++)
        {
            hash = hash * base + map.get(s.charAt(i));
        }

        seen.add(hash);

        // Sliding Window
        for (int i = 10; i < s.length(); i++)
        {
            // Remove leftmost character
            hash = hash - map.get(s.charAt(i - 10)) * power;

            // Shift hash
            hash = hash * base;

            // Add new character
            hash = hash + map.get(s.charAt(i));

            if (seen.contains(hash))
            {
                String sub = s.substring(i - 9, i + 1);

                if (!added.contains(sub))
                {
                    ans.add(sub);
                    added.add(sub);
                }
            }
            else
            {
                seen.add(hash);
            }
        }

        return ans;
    }
}