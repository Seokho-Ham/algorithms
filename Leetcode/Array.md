### 1. Intersection of Two Arrays 2

문제 : 2개의 배열에서 교집합을 찾아내고 배열로 반환하는 문제.
<br>

- 반복되는 횟수만큼 배열에 담아야 한다.

```js
//Ex1
Input: (nums1 = [1, 2, 2, 1]), (nums2 = [2, 2]);
Output: [2, 2];

//Ex2
Input: (nums1 = [4, 9, 5]), (nums2 = [9, 4, 9, 8, 4]);
Output: [4, 9];
```

나의 풀이:

```js
var intersect = function (nums1, nums2) {
  let result = [];
  let n1 = nums1.slice();
  let n2 = nums2.slice();
  if (nums1.length > nums2.length) {
    n1 = nums2.slice();
    n2 = nums1.slice();
  }

  for (let i = 0; i < n1.length; i++) {
    if (n2.includes(n1[i])) {
      result.push(n1[i]);
      delete n2[n2.indexOf(n1[i])];
    }
  }
  return result;
};
```

인자로 들어온 배열의 복사본을 생성하였고 둘 중 더 짧은 배열의 길이만큼 반복문을 돌렸다.
<br>
긴 배열에서 그 값을 가지고 있는지 검사하였고 가지고 있다면 결과값에 저장하였다. 동시에 중복 저장을 피하기 위해 긴 배열에서 그 값을 삭제 하였다.

### 2. Plus One

문제 : 배열로 주어진 숫자에 1을 더해서 반환하는 문제.

```js
//Ex1
Input: digits = [1, 2, 3];
Output: [1, 2, 4];
//Ex2
Input: digits = [4, 3, 2, 1];
Output: [4, 3, 2, 2];
```

나의 풀이 :

```js
var plusOne = function (digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    digits[i]++;
    if (digits[i] > 9) {
      digits[i] = 0;
    } else {
      return digits;
    }
  }
  digits.unshift(1);
  return digits;
};
```

처음에는 배열로 주어진 값을 join 함수를 사용해 Number로 바꾸는 방식을 사용했다.
<br>
하지만 숫자의 길이가 15자리를 넘어가는 케이스에서는 정확한 값이 안나오길래 검새해보니 Javascript에서는 64비트 부동 소수점 방식으로 저장하기 때문에 정수는 15자리까지 정밀도가 유지된다는것을 발견했다.
<br><br>
그래서 for문을 사용해 뒤에서부터 값에 1을 더해 그 숫자가 9를 넘어가면 다음 숫자로 넘어가고 아니라면 현재의 값을 반환해주는 방식으로 풀었다.
<br>
unshift 메소드를 사용한 이유는 케이스 중 하나의 값만 존재하는 경우가 있었고 그 값이 9였다. 기존에 짠 코드로만 실행하면 0만을 반환하기 때문에 맨 앞에 1을 추가해주는 용도로 사용하였다.

### 3. Move Zeroes

문제 : 주어진 배열에 존재하는 0을 모두 배열의 뒤로 이동시키는 문제.
<br>

- 새로운 배열을 만들지 않고 해결해야 한다.
  나의 풀이 :

```js
var moveZeroes = function (nums) {
  for (let i = nums.length - 1; i >= 0; i--) {
    if (nums[i] === 0) {
      nums.push(0);
      nums.splice(i, 1);
    }
  }
};
```

처음에는 for문을 오름차순으로 실행시켰다.
<br>
하지만 이렇게 푸니까 splice 메소드를 씀에 따라 원하는 결과가 나오지 않았다. 그래서 뒤에서부터 반복문을 돌리는 방식으로 바꿔서 풀었다.
<br>
뒤에서부터 해당 값이 0이면 push 메소드를 사용해 배열의 가장 뒤에 0을 추가시키고 기존에 있는 0은 splice 메소드를 사용해 삭제 하였다.

### 4. Rotate Image

문제 : n x n 형태의 2D Matrix가 주어지고 오른쪽으로 90도 회전하는 문제.
<br>

- 새로운 배열을 생성하지 않고, 기존의 배열만을 사용해 문제를 풀어야한다.

```js
//Ex1
Input: matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];
Output: [
  [7, 4, 1],
  [8, 5, 2],
  [9, 6, 3],
];
```

나의 풀이 :

```js
var rotate = function (matrix) {
  if (matrix.length === 1) {
    return matrix;
  }
  let result = [];
  for (let i = 0; i < matrix.length; i++) {
    let arr = [];
    for (let j = matrix.length - 1; j >= 0; j--) {
      arr.push(matrix[j][i]);
    }
    result.push(arr);
  }
  for (let i = 0; i < result.length; i++) {
    matrix[i] = result[i];
  }
};
```

사실 이 문제는 문제에서 제시하는 조건을 충족시키지 못했다.
<br>
기존 배열에서 값만 바꿔가면서 푸는 방식이 생각이 나지 않아 새로운 배열을 만들고 그 배열을 기존의 배열에 복사하는 방식으로 풀었다.

## 오늘의 총평

- 아직 생각의 유연성이 부족하다. 여태까지 풀던 방식과 틀에서 벗어날 필요가 있다.
- 성능면까지 생각하는 연습이 필요하다.
