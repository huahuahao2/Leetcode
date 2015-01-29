import java.util.Stack;
public class Evaluate_Reverse_Polish_Notation {
	public static void main(String[] args) {
		String[] s = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
		System.out.println(evalRPN(s));
	}
    public static int evalRPN(String[] tokens) {
    	int result = 0;
        Stack<Integer> value = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
        	if (tokens[i].equals("/")) {
        		result = value.pop();
        		value.push(value.pop()/result);
        	}
        	else if (tokens[i].equals("-")) {
        		result = value.pop();
        		value.push(value.pop()-result);
        	}
        	else if (tokens[i].equals("+")) {
        		result = value.pop();
        		value.push(result+value.pop());
        	}
        	else if (tokens[i].equals("*")) {
        		result = value.pop();
        		value.push(result*value.pop());
        	}
        	else {
        		value.push(Integer.valueOf(tokens[i]));
        	}
        }
        return value.peek();
    }
    public int evalRPN_2(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int i = stack.pop();
                int j = stack.pop();
                int cur = 0;
                if (s.equals("+"))
                    cur = i+j;
                if (s.equals("-"))
                    cur = i-j;
                if (s.equals("*"))
                    cur = i*j;
                if (s.equals("/"))
                    cur = i/j;
                stack.push(cur);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
