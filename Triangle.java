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
    //list can use get funtion
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] upper_sum = new int[triangle.size()];
        int[] cur_sum = new int[triangle.size()];
        int[] temp = null;
        int ret = Integer.MAX_VALUE;
        for(List<Integer> level : triangle) {
            int k = 0;
            for(int i : level) {
                if (k == 0)
                    cur_sum[k] = upper_sum[k] + i;
                else if(k == level.size()-1)
                    cur_sum[k] = upper_sum[k-1] + i;
                else
                    cur_sum[k] = Math.min(upper_sum[k-1], upper_sum[k]) + i;
                k++;
            }
            temp = upper_sum;
            upper_sum = cur_sum;
            cur_sum = temp;
        }
        for(int i = 0; i < triangle.size() ; i++) {
            ret = Math.min(upper_sum[i], ret);
        }
        return ret;
    }
}
