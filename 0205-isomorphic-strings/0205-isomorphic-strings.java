class Solution {
    public boolean isIsomorphic(String s, String t) {

         HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (!mapS.getOrDefault(chS,0).equals(mapT.getOrDefault(chT,0)))
            {
                return false;
            }

            mapS.put(chS,i + 1);
            mapT.put(chT,i + 1);
        }

        return true;
    }
}