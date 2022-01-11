package baseball;

import exception.InputValidException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import nextstep.utils.Console;
import utils.PlayGameOption;
import utils.PlayGameSentences;

public class PlayGame {

    private String userNumber = "";
    private PlayGameInfo playGameInfo;
    private PlayGameInit playGameInit;

    private static BufferedWriter log = null;

    static {
        log = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private String userInput(){
        boolean isCorrectInput = false;
        String userNumber = "";
        while(!isCorrectInput){
            try{
                log.write(
                    PlayGameSentences
                    .INIT_INPUT_SENTENCE
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.RANDOM_NUMBER_COUNT))+"\n"
                );
                log.flush();
                userNumber = Console.readLine();
                isCorrectInput = inputValidCheck(userNumber);


            }catch(InputValidException | NumberFormatException | IOException exception){
               exception.printStackTrace();
            }
        }

        return userNumber;
    }

    private boolean inputValidCheck(String userNumber) throws InputValidException, NumberFormatException{
        if(userNumber.length() != PlayGameSentences.RANDOM_NUMBER_COUNT) {
            throw new InputValidException(PlayGameSentences
                    .WRONG_INPUT_SENTENCE
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.RANDOM_NUMBER_COUNT)));
        }

        char[] userNumberArr = userNumber
            .toCharArray();

        for(int i=PlayGameSentences.BASEBALL_ZERO_NUMBER; i<PlayGameSentences.RANDOM_NUMBER_COUNT; i++){
            if(userNumberArr[i]<'0' || userNumberArr[i]>'9')
                throw new NumberFormatException(
                    PlayGameSentences
                        .LIMIT_INPUT_NUMBER_SENTENCE
                );
            if(userNumberArr[i]==userNumberArr[(i+1)%PlayGameSentences.RANDOM_NUMBER_COUNT])
                throw new InputValidException(
                    PlayGameSentences
                    .WRONG_INPUT_SENTENCE
                    .replaceAll("[?]",Integer.toString(PlayGameSentences.RANDOM_NUMBER_COUNT)));
        }
        return true;
    }

    private PlayGameInfo baseballGameLogic(String userName){

        PlayGameInfo playGameInfoResult = new PlayGameInfo();

        char[] computerNumberArr = playGameInit.getComputerNumber().toCharArray();
        char[] userNumberArr = userNumber.toCharArray();

        try {

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
            log.write(playGameInfoResult.toString()+"\n");

            log.flush();
        }catch(IOException exception){
            exception.printStackTrace();
        }

        return playGameInfoResult;
    }

    private boolean baseballGameEnd(PlayGameInfo playGameinfo){
        if(playGameinfo.getStrike() == PlayGameSentences.RANDOM_NUMBER_COUNT) return true;
        else return false;
    }
    private boolean repeatGame() {

        int gameMode = 0;
        boolean isRepeatGame = false;
        while(gameMode != PlayGameOption.PLAY.getNumber() &&
            gameMode != PlayGameOption.END.getNumber()
        ){
            try{
                log.write(PlayGameSentences.REPEAT_GAME_SENTENCE);
                log.flush();
                gameMode = Integer.parseInt(Console.readLine());
                checkGameModeNumber(gameMode);
            }catch(NumberFormatException | InputValidException | IOException exception){
                exception.printStackTrace();
            }
        }

        if(PlayGameOption.PLAY.getNumber() == gameMode){
            initProgram();
            isRepeatGame = true;
        }

        if(PlayGameOption.END.getNumber() == gameMode){
            try{
                log.write(PlayGameSentences.GAMEOVER);
            }catch(IOException exception){
                exception.printStackTrace();
            }
        }

        return isRepeatGame;
    }
    private void checkGameModeNumber(int gameMode) throws InputValidException{
        if(gameMode < PlayGameOption.PLAY.getNumber() || gameMode > PlayGameOption.END.getNumber())
            throw new InputValidException(
                PlayGameSentences.
                    WRONG_GAMEMODE_INPUT_SENTENCE
            );
    }



    private void gameStart(){
        userNumber = userInput();
        playGameInfo = baseballGameLogic(userNumber);
    }

    private void initProgram(){
        playGameInit = new PlayGameInit();
    }

    public void start() {
        // TODO 숫자 야구 게임 구현
        initProgram();
        gameStart();

        while(!baseballGameEnd(playGameInfo) || repeatGame()) gameStart();
    }
}
