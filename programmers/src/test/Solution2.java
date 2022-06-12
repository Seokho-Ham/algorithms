package test;

import java.util.Arrays;

public class Solution2 {
    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        int[] paySum = new int[periods.length];
        for (int i = 0; i < payments.length; i++) {
            paySum[i] = Arrays.stream(payments[i]).sum();
        }

        for (int i = 0; i < periods.length; i++) {
            if(periods[i]+1 < 24) continue;

            int currentPaySum = paySum[i];
            int nextPaySum = currentPaySum - payments[i][0] + estimates[i];


            //5년이상
            if (periods[i] + 1 >= 60) {
                //현재는 GOLD이지만 다음달 내면 VIP
                if((periods[i]+1 == 60 && currentPaySum >=600000 && nextPaySum>=600000) || (currentPaySum < 600000 && nextPaySum >= 600000)) {
                    answer[0]++;
                    continue;
                }
                //현재는 VIP지만 다음달 포함하면 GOLD
                if(currentPaySum >= 600000 && nextPaySum < 600000) {
                    answer[1]++;
                    continue;
                }
            }

            //2년~5년
            if((periods[i]+1 == 24 && currentPaySum >=900000 && nextPaySum>=900000) || (currentPaySum < 900000 && nextPaySum >= 900000)) {
                answer[0]++;
                continue;
            }
            //현재는 VIP지만 다음달 포함하면 GOLD
            if(currentPaySum >= 900000 && nextPaySum < 900000) {
                answer[1]++;
                continue;
            }
        }
        return answer;
    }
}

//24개월 미만 X
//중간단계 90만원 이상 내면 O
//60개월 이상이 되면서 60만원 이상 내면 O
