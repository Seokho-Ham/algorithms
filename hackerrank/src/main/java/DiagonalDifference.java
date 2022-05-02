import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftSum = 0;
        int rightSum = 0;
        int ltor = 0;
        int rtol = arr.size()-1;

        for (List<Integer> integers : arr) {
            leftSum += integers.get(ltor);
            rightSum += integers.get(rtol);

            ltor++;
            rtol--;
        }

        return Math.abs(leftSum - rightSum);
    }
}

// 리스트를 순회하면서 2개의 포인트를 두고 하나는 올리고 하나는 내려가면서 합치면 될듯?

