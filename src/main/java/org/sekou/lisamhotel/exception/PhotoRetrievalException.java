package org.sekou.lisamhotel.exception;

public class PhotoRetrievalException extends ResourceNotFoundException {
    public PhotoRetrievalException(String message) {
        super(message);
    }
}
