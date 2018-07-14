package esum.dic;


public class DicException extends UnknownException {
    public DicException(final Throwable t) {
        super(t);
    }

    public DicException(final String message) {
        super(message);
    }
    public DicException(final String message,final Throwable t){
        super(message,t);
    }
}
