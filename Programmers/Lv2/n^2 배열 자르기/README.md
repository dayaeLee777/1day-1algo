# Programmers n^2 배열 자르기
## [문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/87390)
|난이도|
| :--: |
| Lv2 |

## 💡 구현 아이디어
---
left와 right 사이에 해당하는 부분을 1차원 배열로 만들어야한다.
메모리 초과가 발생할 수 있기 때문에 처음부터 map을 생성하기 보단, left~right 사이 구간만을 계산하면서 값을 바로 대입해야한다.

## ✏️ 마치며
---
처음에 map을 만들어두고 풀이를 하려 했으나 메모리 초과로, 구현방식을 answer에 해당하는 값을 계산하는 방식으로 수정했다.