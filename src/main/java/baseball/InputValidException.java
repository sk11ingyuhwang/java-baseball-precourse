package baseball;

public class InputValidException extends RuntimeException {
    public InputValidException(){super();}
    public InputValidException(String message){super(message);}
    public InputValidException(Throwable ex){super(ex);}
    public InputValidException(String message, Throwable ex){super(message,ex);}
}
