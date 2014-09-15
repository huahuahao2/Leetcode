class Multiply_Strings {
    public String multiply(String num1, String num2) {
    	//totally think to the add!
        char[] ret = new char[num1.length() + num2.length()];
        int i = num1.length()-1, j = num2.length()-1, k = ret.length - 1;
        int ii = 0, jj = 0;
        int carr = 0;
        while (i >= 0 && j >= 0) {
        	ii = (int) (num1.charAt(i--) - '0');
        	jj = (int) (num2.charAt(j--) - '0');
        	ret[k--] = (char) ((ii*jj + carr)%10 + '0');
        	carr = (ii*jj + carr)/10;
        }
        while (i >= 0) {
        	ii = (int) (num1.charAt(i--) - '0');
        	ret[k--] = (char) ((ii + carr)%10 + '0');
        	carr = (ii + carr)/10;
        }
        while (j >= 0) {
        	jj = (int) (num2.charAt(j--) - '0');
        	ret[k--] = (char) ((jj + carr)%10 + '0');
        	carr = (jj + carr)/10;
        }
        ret[k] = (char) (carr + '0');
        String ret_str = new String(ret);
        if (ret[0] == '0') {
        	return ret_str.substring(1);
        }
        return ret_str;
    }
    public String multiply2(String num1, String num2) {
    	int[] n1 = new int[num1.length()];
    	int[] n2 = new int[num2.length()];
    	int[][] n = new int[num1.length()][num2.length()+num1.length()];
    	char[] ret = new char[num1.length() + num2.length()];


    	for (int i = 0; i < num1.length(); i++) {
    		n1[i] = (int) (num1.charAt(i) - '0');
    	}
    	for (int i = 0; i < num2.length(); i++) {
    		n2[i] = (int) (num2.charAt(i) - '0');
    	}

        for (int i = num1.length() - 1; i >= 0; i--) {
        	int carr = 0;
        	for (int j = num2.length() -1; j >= 0; j--) {
        		n[i][i+j+1] = (n1[i] * n2[j] + carr) % 10;
        		carr = (n1[i] * n2[j] + carr) / 10;
           	}
        	n[i][i] = carr;
        }

        int carr = 0;
        int sum = 0, k = num2.length()+num1.length()-1;
        for (int j = num2.length()+num1.length()-1; j >= 0; j--) {
        	sum = carr;
        	for (int i = 0; i < num1.length(); i++) {
        		sum += n[i][j];
        	}
        	ret[k--] = (char) ((sum % 10) + '0');
        	carr = sum / 10;
        }
        //ret[k] = (char) (carr + '0');
        String ret_str = new String(ret);
        int i = 0;
        while(i < ret.length && ret[i] == '0')
        	i++;
        if (i < ret.length) {
        	return ret_str.substring(i);
        }
        else {
        	return "0";
        }
        //return ret_str;

    }
}