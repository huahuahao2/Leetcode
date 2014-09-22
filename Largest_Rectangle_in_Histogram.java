import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
	//TLE
	public int largestRectangleArea(int[] height) {
		int max = 0;
        int[][] low_height_matrix = new int[height.length][height.length];
        for (int i = 0; i < height.length; i++) {
         	low_height_matrix[i][i] = height[i];
         	max = max > low_height_matrix[i][i] ? max : low_height_matrix[i][i];
        }
        for (int j = 1; j < height.length; j++) {
        	for (int i = 0; i+j < height.length; i++) {
        		low_height_matrix[i][i+j] = low_height_matrix[i][i+j-1] > low_height_matrix[i+1][i+j] ? low_height_matrix[i+1][i+j] : low_height_matrix[i][i+j-1];
        		max = max > (low_height_matrix[i][i+j] * (j+1)) ? max : (low_height_matrix[i][i+j] * (j+1));
        	}
        }
        return max;
    }
    //consider itself as the lowest one.
    public int largestRectangleArea2(int[] height) { 
    	Stack<Integer> height_s = new Stack<Integer>();
    	Stack<Integer> index_s = new Stack<Integer>();
    	height_s.push(-1);
    	index_s.push(-1);
    	int index = 0, max = 0;
    	while (!height_s.isEmpty()) {
    	    
    		if (index < height.length && height[index] > height_s.peek() ) {
    			height_s.push(height[index]);
    			index_s.push(index++);
    		}
    		else if(index < height.length && height[index] == height_s.peek()) {
    		    index_s.pop();
    		    index_s.push(index++);
    		}
    		else {
    			int cur_h = height_s.pop();
    			index_s.pop();
    			if (cur_h == -1)
    			    break;
    			int old_i = index_s.peek();
    			int cur_max = (index -1 - old_i) * cur_h;
    			max = max > cur_max ? max : cur_max;
    		}
    	}
    	return max;
    }
}