import java.util.HashSet;
import java.util.Iterator;
public class Single_Number {
    public int singleNumber(int[] A) {
    	HashSet<Integer> s = new HashSet<Integer>();
        for(int i = 0; i< A.length; i++) {
        	if(s.contains(A[i])) {
        		s.remove(A[i]);
        	}
        	else
        		s.add(A[i]);
        }
		Iterator<Integer> it = s.iterator();
    	return it.next();
    }
    public int singleNumber2(int[] A) {
    	int single=0;
    	for(int i:A) 
    		single^=i;
    	return single;
    }
}
