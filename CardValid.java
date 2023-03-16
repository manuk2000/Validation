
public class CardValid {

    // Input length Balans
    // prerequisite lengthBalans > 0
    // returns the bank account number with the specified number of characters
    // returns the specified number of characters to the account
    static String createNumberBalanc(int lengthBalans) {
        if (lengthBalans <= 0)
            return null;
        String tmp;
        while (true) {
            tmp = createNumber(lengthBalans);
            if (iscardValid(tmp)) {
                return tmp;
            }
        }
    }

    // Input number of digits
    // prerequisite number of digits > 0
    // returns the number of the specified length in the String
    private static String createNumber(int lengthBalans) {
        String tmp = "";
        while (true) {
            if (lengthBalans <= 12) {
                tmp += String.valueOf((long) (Math.random() * Math.pow(10, lengthBalans)));
                return tmp;
            } else {
                tmp += String.valueOf((long) (Math.random() * Math.pow(10, 12)));
                lengthBalans -= 12;
            }
        }
    }

    // Input the bank account number
    // return is this an estimate or not?
    static boolean iscardValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i += 2) {
            count += (str.charAt(i) - '0');
        }
        for (int i = 1; i < str.length(); i += 2) {
            count += ((str.charAt(i) - '0') * 2) % 10;
            count += ((str.charAt(i) - '0') * 2) / 10;
        }
        return (count % 10) == 0;
    }

}