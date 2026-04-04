import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) 
    {
        int n = deck.length;
        int[] result = new int[n];

        Arrays.sort(deck);

        boolean[] filled = new boolean[n];

        int i = 0;
        int j = 0;
        boolean skip = false;

        while (j < n) 
        {
            if (!filled[i]) 
            {
                if (!skip) 
                {
                    result[i] = deck[j++];
                    filled[i] = true;   
                }
                skip = !skip;
            }

            i = (i + 1) % n;
        }

        return result;
    }
}