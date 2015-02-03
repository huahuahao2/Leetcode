import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
        	List<Integer> prev = null;
        	if (!ret.isEmpty())
        		prev = ret.get(ret.size()-1);
        	List<Integer> list = new ArrayList<Integer>(i+1);
        	list.add(1);
        	for (int j = 1 ; j <= i; j++) {
        		if (j != i)
        			list.add(prev.get(j-1)+prev.get(j));
        		else
        			list.add(1);
        	}
        	ret.add(list);
        }
        return ret;
    }
    
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        for(int i = 1; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>(i);
            cur.add(1);
            if(i!=1) {
                List<Integer> last = list.getLast();
                for(int k = 0; k < i-2; k++) {
                     cur.add(last.get(k)+last.get(k+1));
                }
                cur.add(1);
            }
            list.add(cur);
        }
        return list;
    }
}
