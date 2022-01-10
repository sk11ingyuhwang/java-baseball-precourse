package baseball;

import nextstep.utils.Console;

public class PlayGame {

    private String userNumber = "";
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

        System.out.println(playGameInfoResult.toString());
        return playGameInfoResult;
    }

    public boolean baseballGameEnd(PlayGameInfo playGameinfo){
        if(playGameinfo.getStrike() == PlayGameSentences.RANDOM_NUMBER_COUNT) return true;
        return false;
    }
    public boolean repeatGame() {

        int gameMode = 0;
        boolean isRepeatGame = false;
        while(gameMode != PlayGameOption.PLAY.number &&
            gameMode != PlayGameOption.END.number
        ){
            try{
                gameMode = Integer.parseInt(Console.readLine());
                checkGameModeNumber(gameMode);
            }catch(NumberFormatException | InputValidException exception){
                System.out.println(PlayGameSentences.WRONG_INPUT_SENTENCE);
            }
        }

        if(PlayGameOption.PLAY.number == gameMode){
            initProgram();
            isRepeatGame = true;
        }

        if(PlayGameOption.END.number == gameMode){
            System.out.println(PlayGameSentences.GAMEOVER);
        }

        return isRepeatGame;
    }
    private void checkGameModeNumber(int gameMode) throws InputValidException{
        if(gameMode < PlayGameOption.PLAY.number || gameMode > PlayGameOption.END.number)
            throw new InputValidException();
    }

    private void initProgram(){
        playGameInit= new PlayGameInit();
    }

    public void start() {
        // TODO 숫자 야구 게임 구현

        initProgram();
        //System.out.println("Computer Number : "+playGameInit.getComputerNumber());
        userNumber = userInput();
        //System.out.println("UserNumber : "+userNumber);
        playGameInfo = baseballGameLogic(userNumber);

        while(!baseballGameEnd(playGameInfo) ||
            repeatGame()
        ) {
             userNumber = userInput();
             //System.out.println("Computer Number : "+playGameInit.getComputerNumber());
             playGameInfo = baseballGameLogic(userNumber);

        }
    }
}
