package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(m.containsKey(target - nums[i])){
                return new int[] {i, m.get(target - nums[i])};
            }
            m.put(nums[i], i);
        }
        return null;
    }
//수도코드
//해시 맵을 만들어서 키는 해당 숫자를, 값은 인덱스를 저장하도록 한다.
//만약 target에서 뺀 값이 존재할 경우 배열로 만들어서 반환한다.
}
