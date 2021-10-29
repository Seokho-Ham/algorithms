### 문제

---

- 이어져있는 가게의 돈을 하루에 훔치면 경찰에 알림이 간다.
- 같은날에 훔칠 수 있는 돈의 최대 금액을 반환해라.

### 예시

---

```md
Example 1:
**Input**: nums = [1,2,3,1]
**Output**: 4
**Explanation**: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
**Input**: nums = [2,7,9,3,1]
**Output**: 12
**Explanation**: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
```

### 나의 풀이

---

```java
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }
}

//수도코드
//2부터 시작해서 이전까지 훔친 돈과 전전값+현재값을 비교해가며 더 큰 값을 저장한다.
```
