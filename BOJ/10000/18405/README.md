# BOJ 18405 경쟁적 전염
### [문제 바로가기](https://www.acmicpc.net/problem/18405)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  SilverI | 28.485% | 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색 |

### 💡 구현 아이디어
---
시험관에 존재하는 바이러스는 1초마다 번호순으로 증식되기 때문에 BFS를 적용하도록 한다. <br/>
`PriorityQueue`를 사용하여 시간/번호순으로 정렬이 가능하도록 Virus 클래스에 `Comparable` 인터페이스를 적용한다.

0. Virus 클래스에 Comparable을 적용하여, 시간순 -> 번호순으로 큐가 정렬되도록 함 
1. 바이러스가 존재하면 PriorityQueue에 offer
2. return 조건 <br/>
2-1. X, Y 좌표에 바이러스 존재하면 return <br/>
2-2. S초에 도달했다면 return <br/>
3. 상하좌우를 탐색하며 바이러스가 없는 곳에 바이러스 증식시키고, pq에 offer
4. 결과값 출력  <br/><br/>


### ⏰ 실행시간
---
572 ms<br/><br/>


### ✏️ 마치며
---
2개 이상의 필드로 객체를 비교하기 위해 `Comparable`의 `compareTo`를 구현하면서 `comparing` 메서드를 사용해보았다.
```
Comparator.comparing(Virus::getTime)
                    .thenComparing(Virus::getNum)
                    .compare(this, o);
```

객체 비교는 아직 공부할 부분이 너무 많다..!!! 
