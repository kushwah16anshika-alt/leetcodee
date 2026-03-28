import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // Step 1: Fill queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }

        // Step 2: Process rounds
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();

            if (r < d) {
                // R bans D
                rQueue.offer(r + n);
            } else {
                // D bans R
                dQueue.offer(d + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}