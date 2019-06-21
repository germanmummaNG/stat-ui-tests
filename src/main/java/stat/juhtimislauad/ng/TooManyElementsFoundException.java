package stat.juhtimislauad.ng;

public class TooManyElementsFoundException extends RuntimeException {

    public TooManyElementsFoundException(String selector) {
        super("Found more than 1 element with selector '" + selector + "'");

    }
}
