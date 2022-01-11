package baseball;

import utils.PlayGameSentences;

public class PlayGameInfo {
    private int Strike;
    private int Ball;

    public void setStrike(int strike) {
        Strike = strike;
    }

    public void setBall(int ball) {
        Ball = ball;
    }

    public int getStrike() {
        return Strike;
    }

    public int getBall() {
        return Ball;
    }

    public void addStrke(){
        this.Strike+=1;
    }
    public void addBall(){
        this.Ball+=1;
    }
    public String toString(){
        StringBuilder playGameResult = new StringBuilder();
        if(this.getStrike() == PlayGameSentences.RANDOM_NUMBER_COUNT){
            playGameResult.append(this.getStrike());
            playGameResult.append(PlayGameSentences.STRIKE);
            return playGameResult.toString();
        }
        if(this.getBall() == PlayGameSentences.BASEBALL_ZERO_NUMBER &&
            this.getStrike() == PlayGameSentences.BASEBALL_ZERO_NUMBER
        ){
            playGameResult.append(PlayGameSentences
                .NOTSING
            );
            return playGameResult.toString();
        }
        if(this.getStrike() > PlayGameSentences.BASEBALL_ZERO_NUMBER){
            playGameResult.append(this.getStrike());
            playGameResult.append(PlayGameSentences.STRIKE);
            playGameResult.append(PlayGameSentences.SPACING);
        }
        if(this.getBall() > PlayGameSentences.BASEBALL_ZERO_NUMBER){
            playGameResult.append(this.getBall());
            playGameResult.append(PlayGameSentences.BALL);
        }
        return playGameResult.toString();

    }
}
