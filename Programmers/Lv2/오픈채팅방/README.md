# Programmers 오픈채팅방
## [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42888)
|난이도|
| :--: |
| Lv2 |

## 💡 구현 아이디어
---

### user_id에 해당하는 nickname을 Map 자료구조를 활용하여 업데이트한다.<br/>

#### 구현
1. record 를 반복하며 Enter와 Change인 경우에만 map에 user_id와 nickname을 저장한다. -> map에는 user_id에 해당하는 최종 nickname이 저장됨
2. 결과 출력을 위해 Enter, Leave인 경우에만 answer_num을 더해준다.
3. 다시 record를 반복하며 Enter와 Leave인 경우 해당하는 결과값을 출력해준다.


## ✏️ 마치며
---
다른 사람들의 코드를 확인해보니 `String.format`을 이용하여 `님이 들어왔습니다.`, `님이 나갔습니다.`를 효율적으로 표현할 수 있었다.
