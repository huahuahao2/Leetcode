public class Add_Binary {
	public static void main(String[] args) {
		int[] num = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(addBinary("1111","1111"));
	}
	public static String addBinary(String a, String b) {
		// StringBuffer ret = new StringBuffer();
		int max = a.length() > b.length() ? a.length() : b.length();
		char[] ret = new char[max + 1];
		int i = a.length() - 1;
		int j = b.length() - 1;
		boolean flag = false;
		while (i >= 0 && j >= 0) {
			if (flag) {
				if (a.charAt(i) != '0' || b.charAt(j) != '0') {
					if (a.charAt(i) == '1' && b.charAt(j) == '1')
						ret[max] = '1';
					else
						ret[max] = '0';

				} else {
					ret[max] = '1';
					flag = false;
				}
			} else {
				if (a.charAt(i) != '1' || b.charAt(j) != '1') {
					if (a.charAt(i) == '1' || b.charAt(j) == '1')
						ret[max] = '1';
					else
						ret[max] = '0';

				} else {
					ret[max] = '0';
					flag = true;
				}
			}
			max--;
			i--;
			j--;
		}
		while(i>=0) {
			if (flag) {
				if(a.charAt(i)=='0') {
					ret[max] = '1';
					flag = false;
				}
				else
					ret[max] = '0';
			}
			else {
				ret[max] = a.charAt(i);
			}
			max--;
			i--;
		}
		while(j>=0) {
			if (flag) {
				if(b.charAt(j)=='0') {
					ret[max] = '1';
					flag = false;
				}
				else
					ret[max] = '0';
			}
			else {
				ret[max] = b.charAt(j);
			}
			max--;
			j--;
		}
		if(flag) {
			ret[max] = '1';
			return String.valueOf(ret);
		}
		else {
			ret[max] = '0';
			return String.valueOf(ret).substring(1);
		}
	}
}
