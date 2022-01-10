package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class playGame {

    static String userNumber = "";
    static int[] result;
    private PlayGameInit playGameInit;


//    public String userInput(){
//        return Console.readLine();
//    }
//
//    public void baseballGameLogic(){
//        char[] computerNumberArr = computerNumber.toCharArray();
//        char[] userNumberArr = userNumber.toCharArray();
//
//        for (int i = 0; i < 3; i++) {
//            if (computerNumberArr[i] == userNumberArr[i]) {
//                result[0] += 1;
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if (computerNumberArr[i] != userNumberArr[i] && computerNumber.contains(
//                userNumberArr[i] + "")) {
//                result[1] += 1;
//            }
//        }
//    }
//
//    public boolean isFinish(){
//        if(result[0] == 3){
//            System.out.println("3스트라이크 게임 끝");
//            return true;
//        }
//        return false;
//    }
//
//    public void isNotFinish(){
//        if (result[0] == 0 && result[1] == 0) {
//            System.out.println("낫싱");
//        } else if (result[0] == 0 && result[1] != 0) {
//            for (int i = 0; i < 2; i++) {
//                System.out.println(result[1] + "볼");
//            }
//        } else if (result[0] != 0 && result[1] == 0) {
//            for (int i = 0; i < 2; i++) {
//                System.out.println(result[0] + "스트라이크");
//            }
//        } else {
//            for (int i = 0; i < 2; i++) {
//                //System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
//                System.out.println(result[0] + "스트라이크 " + result[1] + "볼");
//            }
//        }
//    }
//
//    public boolean baseballGameEnd(){
//        if(isFinish()) {
//            System.out.println("다시 시작하시겠습니까? - 1");
//            int selNumber = Integer.parseInt(userInput());
//            if(selNumber == 1){
//                makeRandomNumberComp();
//                return true;
//            }
//            return false;
//        }
//        isNotFinish();
//        return true;
//    }
//
//    public boolean userNumberValidate(String userNumber){
//        if(userNumber.length()!=3) return false;
//        else
//            return true;
//    }
    public void start() {
        // TODO 숫자 야구 게임 구현
        playGameInit= new PlayGameInit();
        System.out.println(playGameInit.getComputerNumber());
//        while(true) {
//            userNumber = userInput();
//            if(!userNumberValidate(userNumber)) continue;
//            result = new int[2];
//            baseballGameLogic();
//            if(baseballGameEnd()) {
//                continue;
//            }
//            else
//                break;
//        }
    }
}
