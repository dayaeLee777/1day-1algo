# Codility Dominator
### [문제 바로가기](https://app.codility.com/programmers/lessons/8-leader/dominator/)

### 💡 구현 아이디어
---
주어진 배열에 나온 값들을 카운팅한다. 만약 카운팅한 값이 주어진 배열의 길이의 1/2 을 초과하면 해당 값을 가지는 인덱스 중 하나를 출력한다. <br/>
주어진 배열의 값을 카운팅하기 위해 `Map`을 활용하였다.
<br/>


### ⛳️ 실행결과
---
| Task Score | Correctness | Performace |
| ------ | ------ | ------ |
|  100% | 100% | 100% | <br/><br/>


### ✏️ 마치며
---
시간 복잡도 `O(N*log(N))` or `O(N)` <br/>
HashMap의 `compute` 대신 `getOrDefault`을 사용하여 풀었다.
