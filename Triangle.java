import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        //int length = triangle.get(triangle.size()-1).size();
        List<Integer> record = new LinkedList<Integer>();
        record.add(0);
        for(List<Integer> row : triangle) {
            if (row.size() == 1)
                record.add(row.get(0));
        	else
        	    record.add(record.get(0) + row.get(0));
        	for (int j = 1; j < row.size(); j++) {
        		int left = record.get(0) + row.get(j);
        		int right = left;
        		if (j != row.size()-1)
        			right = record.get(1) + row.get(j);
        		record.add(left < right ? left : right);
        		record.remove(0);
        	}
        }
        int min = record.get(0);
        for (int i : record) {
        	if (i < min)
        		min = i;
        }
        return min;
    }
}
