package easy;

public class ReverseInteger {
    //Solution1
    public int reverse1(int x) {
        try {
            int num = Math.abs(x);
            String[] str = String.valueOf(num).split("");
            String result = "";

            if (x < 0) {
                result += "-";
            }
            for (int i = str.length - 1; i >= 0; i--) {
                result += str[i];
            }
            return Integer.valueOf(result);

        } catch (NumberFormatException e) {
            return 0;
        }
    }

    //Solution2
    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if ((tmp - x % 10) / 10 != res) return 0;

            res = tmp;
            x = x / 10;
        }
        return res;
    }
}
