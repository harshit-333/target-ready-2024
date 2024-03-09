public class NumToWords {

    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] thousands = {"", "thousand", "million", "billion"};

    public static String inWords(int num) {
        if (num == 0) {
            return "zero";
        }

        StringBuilder words = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, helper(num % 1000) + thousands[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return units[num] + " ";
        } else if (num < 20) {
            return teens[num - 10] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return units[num / 100] + " hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println(inWords(number));
    }
}