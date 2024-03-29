package programmers.kakao.blind2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class 괄호_변환 {


    public static void main(String[] args) {
        괄호_변환 k = new 괄호_변환();

        System.out.println(k.solution("))))))(((((("));
        System.out.println(k.solution(")()("));
    }


    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        if (validate(p)) {
            return p;
        }

        return recur(p);
    }

    private String recur(String p) {
        if (p.isBlank()) {
            return "";
        }
        StringBuilder u = new StringBuilder();
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if(symmetry(u.toString())){
                count = i;
                break;
            }
            u.append(p.charAt(i));
        }

        String v = count == 0 ? "" : p.substring(count);
        v = validate(v) ? v : recur(v);

        if (u.toString().startsWith("(")) {
            return u.append(v).toString();
        }else{
            String n = "(" + v + ")";
            u.replace(0,1,"");
            u.replace(u.length()-1,u.length(),"");
            if (u.length() == 0) {
                return n;
            }
            String convert = Arrays.stream(u.toString().split(""))
                .map(s -> s.equals("(") ? ")" : "(")
                .collect(Collectors.joining());
            return n + convert;
        }
    }

    private boolean validate(String p) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                if (!q.isEmpty() && q.peek() == '(') {
                    q.poll();
                }else{
                    return false;
                }
            }else{
                q.add('(');
            }
        }
        return true;
    }

    private boolean symmetry(String s) {

        if(s.isBlank()) return false;

        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                close++;
            }else{
                open++;
            }
        }

        return open == close;
    }


}

//    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//      3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//      4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//      4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//      4-3. ')'를 다시 붙입니다.
//      4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//      4-5. 생성된 문자열을 반환합니다.