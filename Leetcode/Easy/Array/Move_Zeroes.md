### 문제

---

- 배열 안에 값이 0인 데이터는 뒤로 보낸다.
- 추가적인 배열의 생성 없이, 인자로 들어온 배열 내에서 해당 작업을 해야한다.

<br>

### 예시

---

Example 1:

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

Example 2:

```
Input: nums = [0]
Output: [0]
```

<br>

### 나의 풀이

---

2가지 방식을 사용해서 풀었다.

###### 1. 2중 for문을 사용해서 해결

```java
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }
//수도코드
//배열을 순환
//현재값이 0일 경우 for문을 통해 0이 아닌 값이 나오면 해당 위치와 바꾼다.
}


```

###### 2. 포인트 2개를 잡고 while문을 통해 돌린다.
```js
class Solution {
    public void moveZeroes(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] == 0) {
                f++;
                continue;
            }
            int temp = nums[s];
            nums[s] = nums[f];
            nums[f] = temp;
            s++;
            f++;
        }
    }
};
```
