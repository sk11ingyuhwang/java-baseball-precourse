package baseball;


import nextstep.utils.Console;
import nextstep.utils.Randoms;



public class Application {

    static String computerNumber = "";
    static String userNumber = "";
    static int[] result;

    public static void makeRandomNumberComp(){
        computerNumber = "";
        while (true) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (computerNumber.contains(number + "")) {
                continue;
            }
            computerNumber += number;
            if (computerNumber.length() == 3) {
                break;
            }
        }
    }

    public static String userInput(){
        return Console.readLine();
    }

    public static void baseballGameLogic(){
        char[] computerNumberArr = computerNumber.toCharArray();
        char[] userNumberArr = userNumber.toCharArray();

        for (int i = 0; i < 3; i++) {
            if (computerNumberArr[i] == userNumberArr[i]) {
                result[0] += 1;
             }
        }

        for (int i = 0; i < 3; i++) {
            if (computerNumberArr[i] != userNumberArr[i] && computerNumber.contains(
                userNumberArr[i] + "")) {
                result[1] += 1;
            }
        }
    }

    public static boolean isFinish(){
        if(result[0] == 3){
            System.out.println("3스트라이크 게임 끝");
            return true;
        }
        return false;
    }

    public static void isNotFinish(){
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0 && result[1] != 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println(result[1] + "볼");
            }
        } else if (result[0] != 0 && result[1] == 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println(result[0] + "스트라이크");
            }
        } else {
            for (int i = 0; i < 2; i++) {
                //System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                System.out.println(result[0] + "스트라이크 " + result[1] + "볼");
            }
        }
    }

    public static boolean baseballGameEnd(){
        if(isFinish()) {
            System.out.println("다시 시작하시겠습니까? - 1");
            int selNumber = Integer.parseInt(userInput());
            if(selNumber == 1){
                makeRandomNumberComp();
                return true;
            }
            return false;
        }
        isNotFinish();
        return true;
    }

    public static boolean userNumberValidate(String userNumber){
        if(userNumber.length()!=3) return false;
        else
            return true;
    }
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        makeRandomNumberComp();
        while(true) {
            userNumber = userInput();
            if(!userNumberValidate(userNumber)) continue;
            result = new int[2];
            baseballGameLogic();
            if(baseballGameEnd()) {
                continue;
            }
            else
                break;
        }
    }
}
//shift+open+cmd+l
//option+cmd+;