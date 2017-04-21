package net.astercrono.closeddoors;

public class InvalidHallwayNumberException extends RuntimeException {
	private static final long serialVersionUID = -1927574578413061130L;
	private static final String MESSAGE = "Invalid hallway number. Number must be greater than 0.";

	public InvalidHallwayNumberException() {
		super(MESSAGE);
	}

	public InvalidHallwayNumberException(final Throwable throwable) {
		super(MESSAGE, throwable);
	}
}
