package array.no67addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }


        //to get a bignner than b
        String c = "";
        if (a.length() < b.length()) {
            c = a;
            a = b;
            b = c;
        }

        StringBuilder sba = new StringBuilder(a);
        StringBuilder sbb = new StringBuilder(b);

        a = sba.reverse().toString();
        b = sbb.reverse().toString();

        String curResult = "";
        int jinwei = 0;
        int intResult = 0;

        // 0 48 - 1 49 - 2 50 - 3 51
        // 0+0= 96  0+1=97  1+1=98  1+1+ jinwei = 99
        for (int i = 0; i < a.length(); i++) {
            if (i < b.length()) {
                intResult = a.charAt(i) + b.charAt(i) + jinwei;

            } else {
                intResult = a.charAt(i) + '0' + jinwei;
            }
            jinwei = 0;
            if (intResult > 97) {
                curResult += String.valueOf(intResult - 98);
                jinwei = 1;
            } else {
                curResult += String.valueOf(intResult - 96);
            }
        }

        if (jinwei == 1) {
            curResult += 1;
        }
        sba = new StringBuilder(curResult);


        return sba.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("expect 100. resut is:" + new Solution().addBinary("11", "1"));
        System.out.println("expect ??. resut is:" + new Solution().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        System.out.println("expect ??. resut is:" + new Solution().addBinary("1110110101", "1110111011"));

        System.out.println("expect 10101. resut is:" + new Solution().addBinary("1010", "1011"));
        System.out.println("expect 1. resut is:" + new Solution().addBinary("0", "1"));
        System.out.println("expect 0. resut is:" + new Solution().addBinary("0", "0"));
        System.out.println("expect 110110. resut is:" + new Solution().addBinary("100", "110010"));
    }


    //搞不定超过int类型的数
    public String addBinary3(String a, String b) {

        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

    }

    //搞不定超过int类型的数
    public String addBinary2(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }

        int jinwei = 0;

        long resultInt = Integer.parseInt(a) + Integer.parseInt(b);

        String resullt = "";
        long yushu = 0;
        while (resultInt >= 0) {
            yushu = resultInt % 10 + jinwei;
            jinwei = 0;
            if (yushu > 1) {
                yushu = yushu - 2;
                jinwei = 1;
            }
            resullt = yushu + resullt;

            if (resultInt == 0) {
                yushu = resultInt % 10 + jinwei;
                break;
            }
            resultInt = resultInt / 10;
        }

        if (jinwei == 1) {
            resullt = "1" + resullt;
        }

        if (resullt.charAt(0) == '0') {
            resullt = resullt.substring(1);
        }

        return resullt;
    }
}
