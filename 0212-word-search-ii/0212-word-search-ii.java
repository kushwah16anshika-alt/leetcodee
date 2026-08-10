import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    // Insert word into Trie
    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    // DFS + Backtracking
    private void dfs(char[][] board, int row, int col, TrieNode node) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        // Already visited
        if (board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        // Check Trie
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Word found
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark visited
        board[row][col] = '#';

        // Down
        dfs(board, row + 1, col, next);

        // Up
        dfs(board, row - 1, col, next);

        // Right
        dfs(board, row, col + 1, next);

        // Left
        dfs(board, row, col - 1, next);

        // Backtrack
        board[row][col] = ch;
    }
}