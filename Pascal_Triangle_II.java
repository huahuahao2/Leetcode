import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Pascal_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> ret = new LinkedList<Integer>();
    	ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
        	ret.add(1);
           	for (int j = 1 ; j <= i; j++) {
        		if (j != i)
        			ret.add(ret.get(0)+ret.get(1));
        		else
        			ret.add(1);
        		ret.remove(0);
        	}
        }
        return ret;
    }
}
