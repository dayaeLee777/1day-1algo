# Codility PassingCars
### [문제 바로가기](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)

### 💡 구현 아이디어
--- 
주어진 배열에서 0번째가 동쪽으로 향하고, 3, 4번째가 서쪽으로 향한다면 (0, 3), (0, 4)는 서로 지나치게 되어있다.
1.  먼저 서쪽으로 향하는 모든 자동차를 더하여 `sumOfWest`로 초기화한다.
2. for문을 반복하며 자동차가 동쪽으로 향하면 결과값에 `sumOfWest`을 더한다.
3. 만약 자동차가 서쪽으로 향한다면 `sumOfWest`에서 1을 빼준다.
4. 결과값이 1000000000을 초과하면 -1을 return한다.

<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
시간복잡도를 고려하여 이중for문을 사용하지 않고 sumOfWest를 활용하여 결과값을 구했다. 시간복잡도는 `O(N)`.