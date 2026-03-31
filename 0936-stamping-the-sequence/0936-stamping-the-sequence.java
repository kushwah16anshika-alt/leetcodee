import java.util.*;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();

        int m = S.length;
        int n = T.length;

        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        int stars = 0;

        while (stars < n) {
            boolean doneReplace = false;

            for (int i = 0; i <= n - m; i++) {
                if (!visited[i] && canReplace(T, i, S)) {
                    stars += doReplace(T, i, m);
                    visited[i] = true;
                    doneReplace = true;
                    result.add(i);

                    if (stars == n) break;
                }
            }

            if (!doneReplace) return new int[0];
        }

        Collections.reverse(result);

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private boolean canReplace(char[] T, int pos, char[] S) {
        for (int i = 0; i < S.length; i++) {
            if (T[i + pos] != '?' && T[i + pos] != S[i]) {
                return false;
            }
        }
        return true;
    }

    private int doReplace(char[] T, int pos, int len) {
        int replaced = 0;
        for (int i = 0; i < len; i++) {
            if (T[i + pos] != '?') {
                T[i + pos] = '?';
                replaced++;
            }
        }
        return replaced;
    }
}