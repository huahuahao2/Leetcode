import java.util.Arrays;
import java.util.LinkedList;


public class Permutation_Sequence {
	public static void main(String[] args) {

		System.out.println(getPermutation(4,7));
	}
    public static String getPermutation(int n, int k) {
        //get factory
    	LinkedList<Character> x = new LinkedList<Character>();
    	for (char i = '1'; i <= n+'0'; i++) {
    		x.add(i);
    	}
    	int f = 1;
    	for (int i = n-1;i>0;i--) {
    		f *= i;
    	}
    	StringBuffer ret = new StringBuffer();
    	for(int i = n; k>0&&i>0;i--){
    		ret.append(x.get((k-1)/f));
    		x.remove((k-1)/f);
    		k = k - ((k-1)/f)*f;
    		if(i == 1)
    			break;
    		f/=(i-1);
    	}
    	return ret.toString();
    }
}
