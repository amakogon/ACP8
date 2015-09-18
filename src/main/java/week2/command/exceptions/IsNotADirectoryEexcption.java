package week2.command.exceptions;

/**
 * Created by juff on 17.09.15.
 */
public class IsNotADirectoryEexcption extends Exception {
    public IsNotADirectoryEexcption() {
        super();
    }

    public IsNotADirectoryEexcption(String message) {
        super(message);
    }

    public IsNotADirectoryEexcption(String message, Throwable cause) {
        super(message, cause);
    }

    public IsNotADirectoryEexcption(Throwable cause) {
        super(cause);
    }

    protected IsNotADirectoryEexcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
