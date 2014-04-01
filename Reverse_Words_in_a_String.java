public class Reverse_Words_in_a_String {
	public static void main(String[] args) {
		String s = "     ";
		System.out.println(reverseWords(s));
	}
    public static String reverseWords(String s) {
        String[] seperate = s.split(" ");
        String result = "";
        if (seperate.length == 0)
        	return result;
        if (seperate.length == 1)
        	return seperate[0];
    	if (seperate[seperate.length - 1].length() > 0) {
    		result += seperate[seperate.length - 1];
    	}
        for(int i = seperate.length - 2; i >= 0; i--) {
        	if (seperate[i].length() > 0) {
        		result += " ";
        		result += seperate[i];
        	}
        }
        return result;
    }
}
