import java.util.Arrays;
import java.util.Stack;
public class Valid_Parentheses {
	public static void main(String[] args) {

		System.out.println(isValid("()"));
		
	}
	public static boolean isValid(String s) {
	Stack<Character> temp = new Stack<Character>();
    for(int i = 0; i < s.length(); i++) {
    	char add = s.charAt(i);
    	if (temp.isEmpty()) {
    		temp.add(add);
    		continue;
    	}
    	char top = temp.peek();
    	if (add == ')' && top == '(')
    		temp.pop();
    	else if (add == ']' && top == '[')
    		temp.pop();        	
    	else if (add == '}' && top == '{')
        	temp.pop();  
    	else {
    	    if (add == ')' || add == ']' || add == '}')
    		    return false;
    	    temp.add(add);
    	}
    }
    if(temp.isEmpty())
    	return true;
    else 
    	return false;
}}
