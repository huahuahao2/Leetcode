//import java.util.Arrays;
import java.util.Stack;


public class Simplify_Path {
	public static void main(String[] args) {
		//String path = "../../";
		System.out.println(simplifyPath("/home//foo/"));
	}
    public static String simplifyPath(String path) {
    	int i =0;
    	Stack<String> x = new Stack<String>();
    	while(i<path.length() ){// && path.indexOf("/",i)!=-1){
    		if(i+1==path.length())
    			break;
    		int k = path.indexOf("/",i+1);
    		if(k == -1)
    			k = path.length();
    		String sub = path.substring(i, k);
    		if(sub.equals("/..")) {
    			if(x.size()>0)
    				x.pop();
    		}
    		else if(!sub.equals("/.")&&!sub.equals("/")){
    			x.push(sub);
    		}
    		i = k;	
    	}
    	
    	Object[] ret = x.toArray();
    	if(ret.length == 0)
    		return "/";
    	StringBuffer retval = new StringBuffer();
    	for(Object s : ret) {
    		retval.append(String.valueOf(s));
    	}
    	return retval.toString();
    }
}
