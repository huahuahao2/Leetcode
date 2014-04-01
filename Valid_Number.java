
public class Valid_Number {
	public static void main(String[] args) {
		System.out.println(isNumber2(""));
	}

	public static boolean isNumber(String s) {//stupid one
		s = s.trim();
		if (s.equals(".") || s.equals(""))
		    return false;
		if (s.endsWith("e"))
			return false;
		String[] first = s.split("\\.");
		if (first.length > 2) {
			return false;
		}
		if (first.length == 2) {
			if (!first[0].equals("")) {
				try {
					Integer.valueOf(first[0]);
				} catch (Exception e) {
					return false;
				}
			}
		}
		String[] second = first[first.length - 1].split("e");
		if (second.length > 2) {
			return false;
		}
		if (second.length == 2) {
			try {
				Integer.valueOf(second[0]);
			} catch (Exception e) {
				return false;
			}
		}
		try {
			Integer.valueOf(second[second.length - 1]);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static boolean isNumber2(String s) {
	    s = s.trim();
		if (s.matches("(-|\\+|)(\\.|)(e(-|\\+|)[0-9]+|)"))
		    return false;
		return s.matches("(-|\\+|)[0-9]*(\\.|)[0-9]*(e(-|\\+|)[0-9]+|)");
	}
}
