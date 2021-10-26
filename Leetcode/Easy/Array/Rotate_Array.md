### 문제

---

- 배열의 가장 나중 요소부터 k번만큼 오른쪽으로 이동시킨다.

<br/>

### 예시

---

```md
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

```md
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

<br/>


### 나의 풀이

---
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArr(nums, 0, nums.length-1);
        reverseArr(nums, 0, k-1);
        reverseArr(nums, k, nums.length-1);    
        
    }
    private void reverseArr(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// 수도코드
//1. 뒤에서 k번째 수까지 그대로 앞으로 이동하면 된다.
//2. 기존 배열 내에서 수를 옮기는 방법은..?
//2-1. 맨 끝의 수를 앞으로 당기고 나머지를 미룬다. -> 시간 초과.
// while(k>0){
//             int lastNum = nums[nums.length-1];
//             for(int i=nums.length-1; i>0; i--){
//                 nums[i] = nums[i-1];
//             }
//             nums[0] = lastNum;
//             k--;
//         }

//2-2. 배열을 뒤집는다.
//2-2-1. 앞에서부터 k-1번째 데이터까지 뒤집는다.
//2-2-2. k번째부터 마지막 데이터까지 뒤집는다.
```