# BOJ 1927 최소힙
### [문제 바로가기](https://www.acmicpc.net/problem/1927)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  Silver I | 48.860% | 자료구조, 우선순위큐 |


### 구현
---
배열에 자연수를 추가하고 최소값을 출력해야하기 때문에 우선순위 큐를 사용했다.

#### 로직
1. N만큼 반복하며 input이 0인지 체크

1-1. 0이 아니면 우선순위 큐에 input 추가

1-2. 0이라면 최소값 출력

1-2-1. 우선순위 큐가 비어있다면 0 출력
  

### 결과
---
628 ms


### 마치며
---
배열에 있는 최소값을 제거해야하기 때문에 우선순위 순으로 데이터를 처리하는 우선순위 큐를 사용하였다.
