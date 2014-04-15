import java.lang.Math;
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
        	for (int j = i+1; j < height.length; j++)
        		ret = max(max(height[i],height[j])*(j-i),ret);
    	}
        return ret;
    }

	public int maxArea2(int[] height) {//greedy.
		int len = height.length, low = 0, high = len - 1;
		int maxArea = 0;
		while (low < high) {
			maxArea = Math.max(maxArea,
					(high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return maxArea;
	}
    public int max (int a, int b) {
    	return a > b? a : b;
    }
}
