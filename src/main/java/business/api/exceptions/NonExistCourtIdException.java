package business.api.exceptions;

public class NonExistCourtIdException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "La pista referenciada no existe";

    public static final int CODE = 1;

    public NonExistCourtIdException() {
        this("");
    }

    public NonExistCourtIdException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
