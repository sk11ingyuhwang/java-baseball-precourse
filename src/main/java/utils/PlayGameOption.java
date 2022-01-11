package utils;

public enum PlayGameOption {

    PLAY(1),
    END(2);

    public int number;
    private PlayGameOption(int number){this.number = number;}

    public int getNumber() {
        return number;
    }
}
