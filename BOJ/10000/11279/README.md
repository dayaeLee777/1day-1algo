# BOJ 11279 최대힙
### [문제 바로가기](https://www.acmicpc.net/problem/1927)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  Silver II | 45.299% | 자료구조, 우선순위큐 |


### 구현
---
- 배열에 자연수를 추가하고 최댓값을 출력해야하기 때문에 우선순위 큐를 사용했다.
- 최댓값을 뽑아내야하기 때문에 Collections.reverseOrder()을 활용하여 내림차순으로 정렬되도록 하였다.

#### ⚙️ 로직
0. 우선순위 큐 초기화 -> Collections.reverseOrder()를 적용하여 내림차순 정렬이 되도록 함
1. N만큼 반복하며 input이 0인지 체크
2. 0이 아니면 우선순위 큐에 input 추가
3. 0이라면 최댓값 출력
4. 우선순위 큐가 비어있다면 0 출력
  

### 결과
---
848 ms


### 마치며
---
우선순위큐를 내림차순으로 정렬할때는 `Collections` 를 사용한다. <br/>
```PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder())```
