# Codility MinAvgTwoSlice
### [문제 바로가기](https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/)

### 💡 구현 아이디어
--- 
P와 Q 사이의 평균을 계산하여 가장 작은 값을 가지고 있는 P의 인덱스를 반환한다.
이중for문을 이용하여 구현하였다.
1. P번째 값은 sum에 더한다.
2. Q는 P+1~A.length - 1까지의 범위이며 해당 범위에 해당하는 값을 차례로 Sum에 더한다.
3. 그 평균이 minAverage보다 작다면 minAverage와 minIndex를 업데이트한다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness | Performance |
| ------ | ------ | ------ |
|  60% | 100% | 20% | <br/><br/>


### ✏️ 마치며
---
시간복잡도는 `O(N^2)`으로 Performance에서 20%만 성공했다.
구현방법이 떠오르지 않아 구글링을 해보니 수학적 접근법을 이용해서 풀이해야 O(N)이 나온다고한다. (이 부분은 내가 착안할 수 있을거 같진 않다...)