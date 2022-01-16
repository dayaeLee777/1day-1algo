# BOJ 7785 회사에 있는 사람
### [문제 바로가기](https://www.acmicpc.net/problem/7785)
| 난이도 | 정답률 | 분류 |
| ------ | ------ | ------ |
|  SilverV | 39.000% | 자료 구조, 해시를 사용한 집합과 맵 |

### 💡 구현 아이디어
---
회사원별로 출퇴근 여부를 확인해야하기 때문에 HashMap을 사용하였다<br/>
key는 회사원 이름, value는 출퇴근 여부의 boolean 값으로 초기화했다.
1. 해쉬맵이 회사원 key 값을 가지고 있으면 value값만 다시 지정해준다.
2. 회사원 key를 가지고 있지 않다면 회사원 정보를 put한다
3. 만약 출입기록이 'enter'이면 value는 true이고 아니면 false가 되도록 한다.
4. hashmap 내림차순 정렬
5. value가 true 일때만 출력 <br/><br/>


### ⏰ 실행시간
---
672 ms<br/><br/>


### ✏️ 마치며
---
해쉬맵의 정렬방식에 대한 정리 필요
- Object[] mapkey = officer.keySet().toArray();
- Arrays.sort(mapkey, Collections.reverseOrder());
