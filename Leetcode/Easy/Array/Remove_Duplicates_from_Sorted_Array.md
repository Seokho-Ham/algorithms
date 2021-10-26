### 문제

---

- 인자로 들어온 배열에서 동일한 값은 한번만 나오도록 해야한다.
- 추가적인 배열을 생성하지 않고 기존배열의 값을 대체해야한다.
- return 값으로는 중복되지 않는 배열의 길이.
- 배열의 길이 이후 인덱스의 값들은 중복되도 상관없다.

<br/>

### 예시

---

```js
Input: nums = [1, 1, 2];
Output: 2, (nums = [1, 2]);
//0,1 인덱스 이후의 값은 무엇이 오든 상관없다.
```

```js
Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
Output: 5, (nums = [0, 1, 2, 3, 4]);
//0,1,2,3,4 인덱스 이후의 값은 무엇이 오든 상관없다.
```

<br/>

### 나의 풀이

---
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int point = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[point] != nums[i]){
                point+=1;
                nums[point] = nums[i];
            }
        }
        return point+1;
    }
}

//수도코드
//1. point라는 숫자 변수 하나를 만든다.
//2. for문을 통해 배열을 순환한다.
//3. nums[i]의 값이 nums[point]와 동일하지 않으면 point+1 위치에 해당 값을 저장한다.
```