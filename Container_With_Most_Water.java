
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
        	for (int j = i+1; j < height.length; j++)
        		ret = max(max(height[i],height[j])*(j-i),ret);
    	}
        return ret;
    }
    public int maxArea2(int[] height) {
        int ret = 0;
        for (int i = 1; i < height.length; i++) {
        	for (int j = i+1; j < height.length; j++)
        		ret = max(max(height[i],height[j])*(j-i),ret);
    	}
        return ret;
    }
    public int max (int a, int b) {
    	return a > b? a : b;
    }
}
