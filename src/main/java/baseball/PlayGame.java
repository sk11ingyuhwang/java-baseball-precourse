package baseball;

import nextstep.utils.Console;

public class PlayGame {

    static String userNumber = "";
    static int[] result;
    private PlayGameInit playGameInit;


    public String userInput(){
        boolean isCorrectInput = false;
        String userName = "";
        while(!isCorrectInput){
            try{
                System.out.println(PlayGameSentences
                    .initInputSentence
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.randomNumberCount))
                );
                userName = Console.readLine();
                isCorrectInput = inputValidCheck(userName);
            }catch(InputValidException | NumberFormatException exception){
                System.out.println(PlayGameSentences
                    .wrongInputSentence
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.randomNumberCount))
                );
            }
        }
        return userName;
    }

    private boolean inputValidCheck(String userName) throws InputValidException, NumberFormatException{
        if(userName.length() != PlayGameSentences.randomNumberCount)
            throw new InputValidException();

        char[] userNameArr = userName
            .toCharArray();

        for(int i=0; i<PlayGameSentences.randomNumberCount; i++){
            if(userNameArr[i]<'0' || userNameArr[i]>'9') throw new NumberFormatException();
            if(userNameArr[i]==userNameArr[(i+1)%PlayGameSentences.randomNumberCount]) throw new InputValidException();
        }
        return true;
    }
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

    public void start() {
        // TODO 숫자 야구 게임 구현
        playGameInit= new PlayGameInit();

        //while(true) {
            userNumber = userInput();

//            result = new int[2];
//            baseballGameLogic();
//            if(baseballGameEnd()) {
//                continue;
//            }
//            else
//                break;
        //}
    }
}
