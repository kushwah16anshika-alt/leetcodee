import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            
            if (c == ',') continue;

            if (c == ')') {
                List<Character> values = new ArrayList<>();

                // collect values inside ()
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }

                stack.pop(); // remove '('
                char op = stack.pop(); // operator

                stack.push(solveOp(op, values));
            } else {
                stack.push(c);
            }
        }

        return stack.peek() == 't';
    }

    // 🔥 Missing function
    private char solveOp(char op, List<Character> values) {
        if (op == '!') {
            // NOT → only one value
            return values.get(0) == 't' ? 'f' : 't';
        }

        if (op == '&') {
            // AND → if any 'f', result is 'f'
            for (char v : values) {
                if (v == 'f') return 'f';
            }
            return 't';
        }

        if (op == '|') {
            // OR → if any 't', result is 't'
            for (char v : values) {
                if (v == 't') return 't';
            }
            return 'f';
        }

        return 'f'; // default (won’t reach here normally)
    }
}