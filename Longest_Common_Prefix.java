public class Longest_Common_Prefix {
	public static void main(String[] args) {
		String strs[] = {"","b"};
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix(String[] strs) {
		StringBuffer ret = new StringBuffer();
		int max = 21;
		boolean flag = true;
		if (strs.length == 0)
			return "";
		for (int i = 0; i < strs.length; i++) {
			max = max < strs[i].length() ? max : strs[i].length();
		}
		for (int j = 0; j < max; j++) {
			int i = 0;
			if (strs[i].length() == 0)
				return "";
			char c = strs[i].charAt(j);
			for (; i < strs.length; i++) {
				if (strs[i].charAt(j) != c)
					flag = false;
			}
			if (flag)
				ret.append(c);
			else
				break;
		}
		return ret.toString();
    }
}
