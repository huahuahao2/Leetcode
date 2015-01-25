public class Maximum_Gap {
	public int maximumGap(int[] num) {
		int ret = 1;
		if (num.length < 2) {
			return 0;
		}
		int min = num[0], max = num[0];
        for (int i : num) {
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        int gap = (max-min) / (num.length-1);
        gap = gap == 0 ? 1 : gap;
        int gaps = (max-min) / gap + 1;
        int max_bound[] = new int[gaps];
        int min_bound[] = new int[gaps];
        for (int i = 0; i < gaps; i++) {
        	max_bound[i] = -1;
        	min_bound[i] = -1;
        }

        for (int i = 0; i < num.length; i++) {
        	int index = (num[i]-min) / gap;
        	if (max_bound[index] == -1) {
        		max_bound[index] = num[i]-min;
        	}
        	else
        		max_bound[index] = Math.max(num[i]-min, max_bound[index]);
        	if (min_bound[index] == -1) {
        		min_bound[index] = num[i]-min;
        	}
        	else
        		min_bound[index] = Math.min(num[i]-min, min_bound[index]);
        }
        for (int i = 0; i < gaps - 1; i++) {
        	while (max_bound[i] == -1) {
        		i++;
        	}
        	int j = i+1;
        	if (j > gaps -1)
        		break;
        	while(min_bound[j] == -1)
        		j++;
        	ret = Math.max(min_bound[j] - max_bound[i], ret);
        }
        return ret;
    }
}