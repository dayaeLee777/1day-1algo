# Codility BinaryGap
### [문제 바로가기](https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/)

### 💡 구현 아이디어
---
지점 P를 기준으로 왼쪽 값들의 합과 오른쪽 값들의 합의 차이를 구해야한다.<br/>

1. 배열의 모든 값을 더한 `rightSum`을 구한다.
2. `배열의 길이 - 1`만큼 반복하며 `leftSum`에는 각 배열의 값을 더하고 `rightSum`에서는 값을 뺀다.
3. `leftSum`과 `rightSum`의 차이를 구하고 이 값이 answer보다 작다면 answer에 차이를 대입한다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
시간 복잡도 `O(N)`이다.
