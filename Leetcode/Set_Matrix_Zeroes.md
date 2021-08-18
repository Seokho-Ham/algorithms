### 문제

> m x n 모양의 매트릭스가 주어지고 0이 있는 위치의 행과 열은 모두 0으로 변환해야 한다.

### 예시

```js
Input: matrix = [
  [1, 1, 1],
  [1, 0, 1],
  [1, 1, 1],
];
Output: [
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1],
];
```

### 나의 풀이

```js
var setZeroes = function (matrix) {
  const row = matrix[0].length;
  const col = matrix.length;
  let extraArr = new Array(col);
  for (var i = 0; i < col; i++) {
    extraArr[i] = new Array(row);
  }
  for (let i = 0; i < col; i++) {
    for (let j = 0; j < row; j++) {
      if (matrix[i][j] === 0) {
        extraArr[i][j] = true;
      }
    }
  }
  function rowHelper(matrix, col, row) {
    for (let i = 0; i < row; i++) {
      matrix[col][i] = 0;
    }
  }
  function colHelper(matrix, row, col) {
    for (let i = 0; i < col; i++) {
      matrix[i][row] = 0;
    }
  }

  for (let i = 0; i < col; i++) {
    for (let j = 0; j < row; j++) {
      if (extraArr[i][j]) {
        rowHelper(matrix, i, row);
        colHelper(matrix, j, col);
      }
    }
  }
};
```

### 풀이 방법

1. 2차원 배열을 새롭게 만들어서 matrix의 0이 있는 위치는 모두 true값을 저장했다.
2. 0이 발견되는 경우 행과 열을 모두 0으로 만드는 row,col helper 함수를 만들었다.
3. 2중 for문을 돌려서 extraArr에서 true가 발견되는 경우 helper 함수를 실행했다.
