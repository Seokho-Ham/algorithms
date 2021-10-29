### **문제**

- Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

### **예시**

```md
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [1]
Output: 1

Input: nums = [0]
Output: 0

Input: nums = [-1]
Output: -1

Input: nums = [-100000]
Output: -100000
```

### **나의 풀이**

```java

class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(sum + nums[i] > nums[i]){
                sum = sum + nums[i];
            }else{
                sum = nums[i];
            }
            if(sum > result){
                result = sum;
            }
        }
        return result;
    }
}

//수도코드
//현재 합과 결과값 변수를 생성한다.
//현재합과 현재값을 더한 값과 현재값을 비교해서 둘 중 더 큰 값을 넣는다.
//result도 마찬가지

//다른 사람들이 푼 방식
class Solution2 {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}

```
