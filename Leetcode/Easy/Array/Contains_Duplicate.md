### 문제

---

- 배열 내에 중복되는 값이 있을경우 true, 없을경우 false를 반환한다.

<br/>

### 예시

---

```md
Input: nums = [1,2,3,1]
Output: true

```

```md
Input: nums = [1,2,3,4]
Output: false
```

```md
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

<br/>


### 나의 풀이

---
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    

}
// 수도코드
//1. 배열을 정렬한다.
//2. 다음값과 현재값이 동일할 경우 true를 반환.