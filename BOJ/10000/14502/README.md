# BOJ 14502 연구소
### [문제 바로가기](https://www.acmicpc.net/problem/14502)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  Gold V | 55.344% | 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색 |


### 구현
---
벽을 세우는 과정은 DFS, 안전한 구역을 카운팅하는 과정은 BFS를 적용한다.

#### ⚙️ 로직

1. 벽을 세우기 위해 map을 복사해둔다. 
2. setWalls 메소드에서는 map을 확인하면 빈칸인 경우, 벽을 세워본다. 벽을 세운 후에는 다시 해당위치를 빈칸으로 변경한다.
3. 만약 Count가 3 이상이면 getCountSafeArea를 호출한다.
4. 바이러스가 전파된 map이 필요하기 때문에 virusMap에 기존 map을 복사한다.
5. 바이러스가 있는 위치라면 queue에 넣어둔다.
6. 이제 큐를 확인하면 바이러스 전파가 가능한 곳에는 `virusMap[nx][ny] == 3`로 업데이트하고 해당 위치도 큐에 넣는다.
7. 마지막으로 virusMap에 빈칸인 부분만 카운팅하여 최대값을 찾아낸다. 
  

### 결과
---
708 ms


### 마치며
---
BFS와 DFS를 모두 적용해야하는 문제였다. 처음에 DFS를 생각하지 못해 난관이 있었다.... <br/>
