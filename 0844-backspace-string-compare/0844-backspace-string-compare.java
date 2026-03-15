import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        return build(s).equals(build(t));
    }

    public String build(String str) {

        Stack<Character> st = new Stack<>();

        for(char ch : str.toCharArray()) {

            if(ch != '#') {
                st.push(ch);
            }
            else if(!st.isEmpty()) {
                st.pop();
            }
        }

        StringBuilder result = new StringBuilder();

        for(char c : st) {
            result.append(c);
        }

        return result.toString();
    }
}