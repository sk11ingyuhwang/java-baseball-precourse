package baseball;

import nextstep.utils.Console;

public class PlayGame {

    static String userNumber = "";
    static int[] result;
    private PlayGameInit playGameInit;
    private PlayGameInfo playGameInfo;

    public String userInput(){
        boolean isCorrectInput = false;
        String userNumber = "";
        while(!isCorrectInput){
            try{
                System.out.println(PlayGameSentences
                    .INIT_INPUT_SENTENCE
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.RANDOM_NUMBER_COUNT))
                );
                userNumber = Console.readLine();
                isCorrectInput = inputValidCheck(userNumber);
            }catch(InputValidException | NumberFormatException exception){
                System.out.println(PlayGameSentences
                    .WRONG_INPUT_SENTENCE
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.RANDOM_NUMBER_COUNT))
                );
            }
        }
        return userNumber;
    }

    private boolean inputValidCheck(String userName) throws InputValidException, NumberFormatException{
        if(userName.length() != PlayGameSentences.RANDOM_NUMBER_COUNT)
            throw new InputValidException();

        char[] userNameArr = userName
            .toCharArray();

        for(int i=PlayGameSentences.BASEBALL_ZERO_NUMBER; i<PlayGameSentences.RANDOM_NUMBER_COUNT; i++){
            if(userNameArr[i]<'0' || userNameArr[i]>'9') throw new NumberFormatException();
            if(userNameArr[i]==userNameArr[(i+1)%PlayGameSentences.RANDOM_NUMBER_COUNT]) throw new InputValidException();
        }
        return true;
    }

    private PlayGameInfo baseballGameLogic(String userName){
        PlayGameInfo playGameInfoResult = new PlayGameInfo();

        char[] computerNumberArr = playGameInit.getComputerNumber().toCharArray();
        char[] userNumberArr = userNumber.toCharArray();

        for (int i = PlayGameSentences.BASEBALL_ZERO_NUMBER; i < PlayGameSentences.RANDOM_NUMBER_COUNT; i++) {
            if (computerNumberArr[i] == userNumberArr[i]) {
                playGameInfoResult.addStrke();
            }
        }

        for (int i = PlayGameSentences.BASEBALL_ZERO_NUMBER; i < PlayGameSentences.RANDOM_NUMBER_COUNT; i++) {
            if (computerNumberArr[i] != userNumberArr[i] && playGameInit.getComputerNumber().contains(
                userNumberArr[i] + "")) {
                playGameInfoResult.addBall();
            }
        }
        return playGameInfoResult;
    }
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
    public boolean baseballGameEnd(PlayGameInfo playGameinfo){
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

    }


    public void start() {
        // TODO 숫자 야구 게임 구현
        playGameInit= new PlayGameInit();

        while(baseballGameEnd(playGameInfo)) {
            userNumber = userInput();

//            result = new int[2];
              playGameInfo = baseballGameLogic(userNumber);
//            if(baseballGameEnd()) {
//                continue;
//            }
//            else
//                break;
        }
    }
}
