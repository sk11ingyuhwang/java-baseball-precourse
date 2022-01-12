# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 구현할 기능 
### directory
```
main
| -- java
|     `-- baseball
|          `-- Application
|          `-- PlayGame
|          `-- PlayGameInfo
|          `-- PlayGameInit
|     `-- exception
|          `-- InputValidException
|     `-- nextstep.utils
|          `-- Console
|          `-- Randoms
|     `-- utils
|          `-- PlayGameOption
|          `-- PlayGameSentence
| --
```
* Application 시작
  * PlayGame().start()로 thread가 생성됩니다. 
    * start()는 다음 함수를 포함하고 있습니다. 
      * initProgram()
        * Computer에서 랜덤한 숫자 3개를 받아옵니다.
      * gameStart()
        * User의 서로 다른 숫자 3개를 받아옵니다. 
        * Computer 랜덤 숫자와 User의 랜덤 숫자를 서로 비교 합니다. 
          * strike, ball 각각 계산하여 화면에 출력합니다. 
    * baseballGameEnd()
      * strike, ball 정보를 기반으로 strike 3번으로 게임이 끝났는지 검사한다.
    * repeatGame()
      * strike가 3개인 상태에서 야구 게임을 다시 실행할건지 종료할건지 선택하는 역할을 수행한다. 
      * 게임을 다시 시작하면 gameStart() 함수를 콜백한다. 


## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
