package webProgramming.recommendTravel.common;

import org.springframework.dao.DataIntegrityViolationException;

public class Exceptions extends RuntimeException{
    public static class DuplicateEntryException extends RuntimeException {
        public DuplicateEntryException(String message, DataIntegrityViolationException e) {
            super(message);
        }
    }

    public static class RegistrationException extends RuntimeException {
        public RegistrationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
