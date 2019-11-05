package dad.javafx.dogs.client;

@SuppressWarnings("serial")
public class DogServiceException extends Exception {

	public DogServiceException() {
		
	}

	public DogServiceException(String message) {
		super(message);
		
	}

	public DogServiceException(Throwable cause) {
		super(cause);
		
	}

	public DogServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DogServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
