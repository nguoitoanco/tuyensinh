package app.admission.exception;

public class CommonException extends Exception {
    private String errorMessage;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CommonException() {
        super();
    }

    public CommonException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public CommonException(Exception e) {
        super(e);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}