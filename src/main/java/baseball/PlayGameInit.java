package baseball;

import nextstep.utils.Randoms;
import utils.PlayGameSentences;


public class PlayGameInit {
    private String computerNumber = "";
    private Randoms random;

    public PlayGameInit(){
        makeRandomNumberComp();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    private void makeRandomNumberComp(){

        setComputerNumber("");

        while (true) {
            int number = Randoms.pickNumberInRange(PlayGameSentences.BASEBALL_START_NUMBER, PlayGameSentences.BASEBALL_LAST_NUMBER);
            if (computerNumber.contains(String.valueOf(number))) {
                continue;
            }
            computerNumber += number;
            if (computerNumber.length() == PlayGameSentences.RANDOM_NUMBER_COUNT) {
                break;
            }
        }
        //System.out.println(getComputerNumber());
        //return getComputerNumber();
    }
}
