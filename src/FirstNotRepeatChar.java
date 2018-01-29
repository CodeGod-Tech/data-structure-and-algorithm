/**
 * Created by Leon on 2018-01-27.
 */
public class FirstNotRepeatChar {

    public static int firstNotRepeatChar(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            hash[temp]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (hash[temp] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String test = "abcdbea";
        System.out.println(firstNotRepeatChar(test));
    }


}
