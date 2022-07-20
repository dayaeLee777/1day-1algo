# Codility FrogRiverOne
### [문제 바로가기](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)

### 💡 구현 아이디어
---
개구리가 반대편으로 점프해갈 수 있는 최단시간을 확인해야한다. 주어진 X보다 작거나 같은 값을 갖는다면 `HashSet`에 추가하여 HashSet의 사이즈가 X와 같아진다면 결과값을 출력한다. <br/>

1. A배열을 0번째부터 확인하며 a번째 값이 X보다 같거나 작은 값이면 HashSet에 추가한다. 
2. set의 사이즈가 X와 같으면 개구리가 반대편으로 건너갈 수 있는 최단시간이므로 반복을 종료한다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
중복이 없는 `HashSet`을 이용하여 개구리가 점프해갈 수 있는 최단시간을 구한다. 시간 복잡도 `O(N)`이다.
