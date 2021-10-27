### 문제

---

- 2개의 배열을 인자로 받아 중복된 값들을 중복된 개수만큼 새로운 배열에 담아서 반환한다.

<br>

### 예시

---

Example 1:

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```

Example 2:

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
```

<br>

### 나의 풀이

---

2가지 방식을 사용해서 풀었다.

###### 1. 2개의 배열을 복사하여 더 긴 배열을 반복문을 돌렸다.

- 동일한 값이 있을 경우 짧은쪽 배열의 해당 값을 0으로 변경하고 arraylist에 저장했다.

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return helper(nums2,nums1);
        }
        return helper(nums1, nums2);
    }
    
    private int[] helper(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
    
        int[] result = new int[list.size()];
        int size = 0;
        for(int num : list){
            result[size++] = num;
        }
        return result;
    }
}

//수도코드
//2차원 배열을 돌린다.
//한쪽 배열에서 동일한 값이 발견되면 0으로 만든다.
```

###### 2. 인자로 들어온 배열을 sort메서드로 정렬한 후 포인터를 사용하였다.

- 2개의 point를 두고 값이 같으면 결과값에 넣기.
- 값을 비교하여 작은쪽의 point를 하나씩 늘려가며 비교했다.

```js
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(nums1.length < nums2.length){
            int[] temp = Arrays.copyOf(nums1, nums1.length);
            nums1 = Arrays.copyOf(nums2, nums2.length);
            nums2 = temp;
        }
        
        int[] result = new int[nums1.length];
        
        int point1 = 0;
        int point2 = 0;
        int index = 0;
        
        while(point1 < nums1.length && point2 < nums2.length){
            if(nums1[point1] < nums2[point2]){
                point1++;
            }else if(nums1[point1] > nums2[point2]){
                point2++;
            }else if(nums1[point1] == nums2[point2]){
                result[index++] = nums1[point1++];
                point2++;
            }
        }
        return Arrays.copyOf(result, index);
        
    }
};
//수도코드
//정렬시킨다.
//[1,1,2,2] / [2,2]
//2개의 포인트를 만든다.
//작은쪽 포인트를 1 더한다.
// 같을경우 해당 값을 저장하고 양쪽 포인트를 올린다.
```
