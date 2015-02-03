//be very careful with everything
public class Candy {
	public static void main(String[] args) {
		int[] num = {3,0,-2,-1,1,2};
		System.out.println(candy(num));

		System.out.println(candy2(num));
	}
	public static int candy(int[] ratings) {
		int candy = 1, max = 1, sum = 1;
		Boolean trend[] = new Boolean[ratings.length];
		for (int i = 0; i < ratings.length-1; i++) {
			if (ratings[i] <= ratings[i+1]) {
				trend[i] = true;
			}
			else
			    trend[i] = false;
		}
		trend[ratings.length-1] = true;
		for (int i = 1; i < ratings.length; i++) {
			if (trend[i-1]) {
				if (ratings[i-1] < ratings[i])
					candy++;
				else
					candy = 1;
				sum += candy;
				if (!trend[i]) {
					max = candy;
					candy = 1;
				}
			}
			else {
				sum += candy++;
				if (trend[i]) {
					if (max < candy)
						sum += candy-max;
					candy = 1;
				}
			}
		}
		return sum;
	}
	//need to think the equal case.
	//and all the possiblity of ups and downs
    public static int candy2(int[] ratings) {
        int sum = 1, last_peak = 0;
        if (ratings.length == 0)
        	return 0;
        for(int i = 0; i < ratings.length-1; ) {
            int count_consecutive = 1;

            while(i < ratings.length-1 && ratings[i] <= ratings[i+1]) {
                if (ratings[i] != ratings[i+1])
            	    count_consecutive++;
            	else
            	    count_consecutive = 1;
                sum += count_consecutive;
                i++;
            }
            last_peak = count_consecutive;
            count_consecutive = 1;
            while(i < ratings.length-1 && ratings[i] > ratings[i+1]) {
                
                sum += count_consecutive;
                //if (ratings[i] != ratings[i+1])
                    count_consecutive++;
                i++;
            }
            if(count_consecutive > last_peak) {
            	sum += count_consecutive - last_peak;
            }
            last_peak = Integer.MAX_VALUE;


        }
        return sum;
    }
    //see from the discuss. just scan from start to end and end to start. buid up the new array.
}
