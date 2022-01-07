# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
1. 숫자 야구
   1. 실질적인 로직
      1. 컴퓨터: 임의의 수 생성 (nextstep.utils.Random API의 pickNumberInRange() 이용)
      2. 사용자: 수 입력 (nextstep.utils.Console API의 readLine() 이용)
      3. 입력한 수가 컴퓨터가 랜덤으로 생성한 수 비교 -> checkNumber() 활용할 예정
         1. 3 스트라이크라면, 정답 안내 후 종료 여부 판단(1.2)으로 넘어감
         2. 이외의 경우, 1.1.1.2의 과정으로 다시 진행
   2. 종료 여부 판단
      1. 사용자 1/2 중 입력
         1. 1 입력 : 새로 시작
         2. 2 입력 : 완전히 종료 -> 2번 과정으로 넘어감
2. 완전히 종료
