import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        Stack<String> cur = new Stack<String>();
        Stack<Integer> count = new Stack<Integer>();
        List<String> ret = new ArrayList<String>();
        if (n != 0) {
        	cur.push("(");
        	count.push(1);
        }
        while (!cur.isEmpty()) {
        	String s = cur.pop();
        	int left = count.pop();
        	if (left < n) {
        		cur.push(s+"(");
        		count.push(left+1);
        	}
        	else {
        		int i = n*2-s.length();
        		while (i-- > 0) {
        			s += ")";
        		}
        		ret.add(s);
        		continue;
        	}
        	if (left*2 - s.length() > 0) {
        		cur.push(s+")");
        		count.push(left);
        	}
        }
        return ret;
    }
}