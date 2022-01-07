# BOJ 1764 듣보잡
### [문제 바로가기](https://www.acmicpc.net/problem/1764)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  SilverIV | 39.954% | 자료구조, 문자열, 정렬, 해시를 사용한 집합과 맵 |

### 💡 구현 아이디어
---
듣도못한/보도못한 2개의 명단 간에 중복되는 데이터가 있는지 확인해야한다.<br/>
이를 위해 중복되는 요소를 허용하지 않는 **HashSet**을 적용했다.
1. 명단 HashSet set에 add
2. add 시, return값(T/F) 체크하여 중복된 값은 ArrayList res에 저장
3. res 오름차순 정렬 <br/><br/>


### ⏰ 실행시간
---
324 ms<br/><br/>


### ✏️ 마치며
---
ArrayList의 정렬방식에 대한 완벽한 이해가 부족한 것 같다. 정리가 필요히다!!
- Collections.sort()
- List.sort()
- 사용자 정의(Comparable, Comparator)
