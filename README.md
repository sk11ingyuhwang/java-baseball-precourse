# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 구현할 기능 
* 컴퓨터 랜덤 숫자 3개 만들기
  * `makeRandomNumberComp`
    * `Randoms.pickNumberInRange` method를 활용하여 1~9까지 각자 다른 숫자 중 3개를 선택한다.
* 유저 숫자 3개 입력 받기
  * `userInput`
    * `Console.readLine()` method를 활용하여 userNumber 3자리를 입력받는다. 
    * `userNumberValidate` 로 userNumber 길이가 3인지 여부를 점검한다. 
* 볼, 스트라이크인지 확인하는 작업을 추가
  * `baseballGameLogic`
    * 볼의 경우 String Method `contains` 함수를 이용하여 구현한다. 
    * 스트라이크 경우 하드 코딩으로 각 자릿수의 위치가 일치하는지 확인한다.
    * 각 결과는 `result` 에 담아 관리한다. 
* 컴퓨터와 유저 사이에 숫자가 일치한다면 종료한다.
  * `baseballGameEnd`
      * 이때, 다시 시작하는 경우라면 `1`을 입력받는다. 
      * 그렇지 않다면, 게임은 종료한다. 


## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
