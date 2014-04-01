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
}
