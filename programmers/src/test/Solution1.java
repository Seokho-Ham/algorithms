package test;

public class Solution1 {
    public int[] solution(int[] p) {
        int index = 0;
        int[] count = new int[p.length];

        while (index < p.length - 1) {

            int num = p.length;
            int cur = 0;

            for (int i = index; i < p.length; i++) {
                if (p[i] < num) {
                    num = p[i];
                    cur = i;
                }
            }
            if (p[index] > p[cur]) {
                int temp = p[index];
                p[index] = p[cur];
                p[cur] = temp;

                count[index]++;
                count[cur]++;
            }

            index++;
        }
        return count;
    }
}
//매번 회차마다 가장 작은 값을 찾아서 현재 i값과 비교.
