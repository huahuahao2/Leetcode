import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
public class Majority_Element {
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i : num) {
        	if (h.containsKey(i)) {
        		int count = h.remove(i) + 1;
        		h.put(i, count);
        	}
        	else {
        		h.put(i, 1);
        	}
        }
		Iterator iter = h.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			if ((Integer)val > num.length/2) {
				return (Integer)key;
			}
		}
		return 0;
	}
}