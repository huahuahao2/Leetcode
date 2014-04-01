import java.util.Arrays;
import java.util.Hashtable;

public class Two_Sum {

	public static void main(String[] args) {
		int[] numbers  = {2, 7, 11, 15, 7};
		System.out.println(Arrays.toString(twoSum2(numbers, 9)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		if (numbers.length < 2)
			return ret;
		for (int i = 0; i < numbers.length; i++) {
			ret[0] = i + 1;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] > target)
					continue;
				ret[1] = j + 1;
				if ((numbers[i] + numbers[j]) == target)
					return ret;
			}
		}
		return new int[2];
	}
	public static int[] twoSum2(int[] numbers, int target) {
		int[] ret = new int[2];
		Hashtable<Integer, Integer> table = new Hashtable<Integer,Integer>();
		if (numbers.length < 2)
			return ret;
		for (int i = 0; i < numbers.length; i++) {
			if (table.containsKey(target-numbers[i]))
			{
				ret[0] = table.get(target-numbers[i])+1;
				ret[1] = i + 1;
				return ret;
			}
			else
				table.put(numbers[i], i);
		}
		return new int[2];
	}
}