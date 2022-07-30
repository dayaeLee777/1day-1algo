# Codility MaxProductOfThree
### [문제 바로가기](https://app.codility.com/programmers/lessons/6-sorting/max_product_o_three/)

### 💡 구현 아이디어
---
주어진 배열에서 3개 값을 추출하여 곱한 값이 최대값인 것을 구한다.
1. 배열을 정렬한다.
2. 가장 큰 값 3개를 곱한 값을 구한다.
3. 가장 작은 값 2개와 가장 큰 값을 곱한 것을 구한다. -> 음수 2개를 곱한 값이 양수 2개를 곱한 값보다 클수도 있음
4. 2, 3번을 비교하여 큰 값이 결과값이 된다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
시간 복잡도 `O(N*log(N))`이다.
