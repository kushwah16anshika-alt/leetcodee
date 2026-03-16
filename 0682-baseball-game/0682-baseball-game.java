import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();

        for (String op : ops)
            if (op.equals("+")) st.push(st.peek() + st.get(st.size()-2));
            else if (op.equals("D")) st.push(st.peek() * 2);
            else if (op.equals("C")) st.pop();
            else st.push(Integer.parseInt(op));

       int sum = 0;

       for(int num : st)
       {
           sum += num;
       }

    return sum; 
    }
}