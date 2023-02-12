public class Palindrome {
    public static void main(String[] args) {
        String str = "abba";

        System.out.println(Palindrome(str));

    }
        public static boolean Palindrome(String str ){
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

    }











