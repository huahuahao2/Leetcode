
public class Valid_Palindrome {
	public static void main(String[] args) {
		String s = "a2b2a";
		System.out.println(isPalindrome2(s));
	}
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        char[] str = s.toCharArray();
        while (i < j) {
            while (!(str[i] >= 'A' && str[i] <= 'Z') && !(str[i] >= 'a' && str[i] <= 'z'))
            	i++;
            while (!(str[j] >= 'A' && str[j] <= 'Z') && !(str[j] >= 'a' && str[j] <= 'z') && j > i)
            	j--;
            if (i < j) {
            	if (s.substring(i,i+1).toLowerCase().compareTo(s.substring(j,j+1).toLowerCase()) != 0)
            		return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(String s) {
        int i = 0, j = s.length()-1;
        char[] str = s.toLowerCase().toCharArray();
        while (i < j) {
            while (!(str[i] >= 'A' && str[i] <= 'Z') && !(str[i] >= 'a' && str[i] <= 'z') && !(str[i] >= '0' && str[i] <= '9') && i < j)
            	i++;
            while (!(str[j] >= 'A' && str[j] <= 'Z') && !(str[j] >= 'a' && str[j] <= 'z') && !(str[j] >= '0' && str[j] <= '9') && j > i)
            	j--;
            if (i < j) {
            	if (str[i++] != str[j--])
            		return false;
            }
        }
        return true;
    }
}
