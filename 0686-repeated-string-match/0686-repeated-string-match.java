class Solution {

    public int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private boolean kmpSearch(String text, String pat) {
        int[] lps = buildLPS(pat);

        int i = 0, j = 0;
        int n = text.length();
        int m = pat.length();

        while (i < n) {

            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            }

            else if (i < n && text.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (kmpSearch(sb.toString(), b)) {
            return count;
        }

        sb.append(a);

        if (kmpSearch(sb.toString(), b)) {
            return count + 1;
        }

        return -1;
    }
}