package baseball;

import nextstep.utils.Randoms;


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
            int number = Randoms.pickNumberInRange(playGameSentences.baseballStartNumber, playGameSentences.baseballLastNumber);
            if (computerNumber.contains(number + "")) {
                continue;
            }
            computerNumber += number;
            if (computerNumber.length() == playGameSentences.randomNumberCount) {
                break;
            }
        }
        //System.out.println(getComputerNumber());
        //return getComputerNumber();
    }
}
