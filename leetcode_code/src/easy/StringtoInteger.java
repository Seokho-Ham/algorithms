package easy;

import java.util.ArrayList;
import java.util.List;

public class StringtoInteger {
    public int myAtoi(String s) {
        boolean positive = true;
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                positive = false;
            } else if (Character.isDigit(s.charAt(i))) {
                answer += Character.toString(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                continue;
            } else {
                break;
            }
        }
        if (answer.length() < 1) {
            return 0;
        }
        int result = 0;
        try {
            result = positive ? Integer.parseInt(answer) : Integer.parseInt(answer) * -1;
        } catch (NumberFormatException e) {
            if (positive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        return result;
    }
}


//수도코드
//1. -, + 를 구분한다.
//2. 문자열이 오면 끊는다.
//3. 공백은 무시한다.
//4. int의 범위가 넘어가면 최대값, 최소값으로 반환한다.