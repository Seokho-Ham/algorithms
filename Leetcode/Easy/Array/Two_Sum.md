### 문제

---

- nums라는 배열과 target 이라는 숫자를 인자로 받는다.
- nums에서 2개의 값을 더해서 target값이 되는 elements들의 index값을 담은 배열을 반환해라.

<br>

### 예시

---

```md
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
```

```md
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

```md
Input: nums = [3,3], target = 6
Output: [0,1]
```

<br>

### 나의 풀이 :

---

```java
class Solution {
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
}
//수도코드
//해시 맵을 만들어서 키는 해당 숫자를, 값은 인덱스를 저장하도록 한다.
//만약 target에서 뺀 값이 존재할 경우 배열로 만들어서 반환한다.
```
