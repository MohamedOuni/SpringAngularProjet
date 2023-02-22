package esprit.tn.projetspringbootangular.Exception;

public class SpringForumException extends RuntimeException {
    public SpringForumException(String message) {
        super(message);
    }

    public SpringForumException(String message, Throwable cause) {
        super(message, cause);
    }
}

