# Codility MaxDoubleSliceSum
### [문제 바로가기](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/)

### 💡 구현 아이디어 및 방법
MaxSliceSum을 응용한 문제이다.
두 개의 부분합을 더헤 최대값을 구하는 것이다.
이를 위해 MaxSliceSum과 같이 카데인 알고리즘을 적용했는데 이전 문제와 달랐던 점은 부분합의 경계가 될 수도 있기 때문에 `Math.max(0, sumX[i - 1] + A[i]`과 같이 max 계산시 0을 적용했다는 것이다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness | Performance |
| ------ | ------ | ------ |
|  100% | 100% | 100% | 

 <br/><br/>


### ✏️ 마치며
---
시간복잡도 `O(N)` <br/>
DP를 정복한 줄 알았지만 카데인 알고리즘의 응용버전에서 허덕였다.... DP를 적용하여 풀 수 있는 문제가 많기 때문에 규칙성을 찾을 수 있도록 사고를 말랑말랑하게 할 필요성을 느꼈다.