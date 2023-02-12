public class Palindrome1 {

    public static boolean Palindrome1(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;

            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(Palindrome1(str));

    }

}