package easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String firstWord = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(firstWord) != 0) {
                System.out.println(firstWord);
                firstWord = firstWord.substring(0,firstWord.length()-1);
            }
        }
        return firstWord;
    }

    public static void main(String[] args) {
        LongestCommonPrefix ls = new LongestCommonPrefix();
        ls.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
