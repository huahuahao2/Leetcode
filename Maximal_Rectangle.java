import java.util.Stack;

public class Maximal_Rectangle {
	//damn difficult!!!

    public int maximalRectangle(char[][] matrix) {
    	int[][] height = new int[matrix.length][matrix[0].length];
    	for (int j = 0; j < matrix[0].length; j++) {
	    	for (int i = matrix.length - 1; i >= 0; i--) {
	    		if (matrix[i][j] == '1') {
	    			if (i == matrix.length - 1) {
	    				height[i][j] = 1;
	    			}
	    			else
	    				height[i][j] = height[i+1][j];
	    		}
	    		else {
	    			height[i][j] = 0;
	    		}
	    	}
    	}
    	int max = 0, cur = 0;
    	for (int i = 0; i < matrix.length; i++) {
    		cur = largestRectangleArea(height[i]);
    		max = max > cur ? max : cur;
    	}
    	return max;
    }
    public int largestRectangleArea(int[] height) { 
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