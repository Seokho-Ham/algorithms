### 문제

---

- 배열 내에 중복되지 않는 하나의 숫자를 반환한다.
- 길이가 1이면 그 숫자만 반환한다.

<br/>

### 예시

---

```md
Input: nums = [2,2,1]
Output: 1
```

```md
Input: nums = [4,1,2,1,2]
Output: 4
```

```md
Input: nums = [1]
Output: 1
```

<br/>


### 나의 풀이

---
```java
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int result=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i==0){
                if(nums[i]!= nums[i+1]){
                    result = nums[i];
                    break;
                }
            }else if(i==nums.length-1){
                if(nums[i]!= nums[i-1]){
                    result = nums[i];
                    break;
                }
            }else{
                if(nums[i]!= nums[i+1] && nums[i]!= nums[i-1]){
                    result = nums[i];
                    break;
                }
            }
            
        }
        return result;
    }
}
// 수도코드
//1. 길이가 1이면 배열의 첫번째 요소를 반환한다.
//2. 배열을 정렬한 후 앞,뒤 값을 비교해서 결과값을 찾는다.
```

<br/>

### 다른 사람들의 풀이
- 배타적 논리합을 사용해서 결과값을 도출한다.
- x와 동일한 값이면 x는 0이 되고, 다른 값이면 해당 값이 된다.
```java
class Solution{
      public int singleNumber(int[] nums) {
        int x = 0;
        for(int i : nums) {
            x^= i;
        }
        return x;
    }
}
```