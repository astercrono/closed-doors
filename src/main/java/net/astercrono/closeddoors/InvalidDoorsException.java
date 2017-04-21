package net.astercrono.closeddoors;

public class InvalidDoorsException extends RuntimeException {
	private static final long serialVersionUID = -1927574578413061130L;
	private static final String MESSAGE = "Invalid number of doors. Number of doors must be greater than 0.";

	public InvalidDoorsException() {
		super(MESSAGE);
	}

	public InvalidDoorsException(final Throwable throwable) {
		super(MESSAGE, throwable);
	}
}
