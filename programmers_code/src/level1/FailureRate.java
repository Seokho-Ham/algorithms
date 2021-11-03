package level1;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        for(int i=1; i<N; i++){

        }

        return answer;
    }
}

// 1. 중복값을 제거한 배열 A를 만든다.
// 2. for문을 통해 A를 순환한다.
// 3. Stream으로 A[i]값의 개수 / Arrays.stream().filter(s -> s>=A[i]).count 값이 실패율
// 4. 해당 값을 Map에 저장.
// 5. 순서대로 배열에 담아서
