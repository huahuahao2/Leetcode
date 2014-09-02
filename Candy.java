//be very careful with everything
public class Candy {
	public static void main(String[] args) {
		int[] num = {3,0,-2,-1,1,2};
		System.out.println(candy(num));
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
}
