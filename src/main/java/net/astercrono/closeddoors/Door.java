package net.astercrono.closeddoors;

public class Door {
	private int number;
	private DoorState state = DoorState.CLOSED;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void open() {
		setState(DoorState.OPEN);
	}
	
	public void close() {
		setState(DoorState.CLOSED);
	}
	
	public boolean isOpen() {
		return getState() == DoorState.OPEN;
	}
	
	public boolean isClosed() {
		return getState() == DoorState.CLOSED;
	}
	
	public void toggle() {
		if (isOpen()) {
			close();
		}
		else
		{
			open();
		}
	}
	
	public DoorState getState() {
		return state;
	}

	public void setState(DoorState state) {
		this.state = state;
	}
}
