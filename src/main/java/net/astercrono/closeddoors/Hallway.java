package net.astercrono.closeddoors;

import java.util.ArrayList;
import java.util.List;

public class Hallway {
	private int number;
	private List<Door> doors;

	public Hallway(final int number, final int numberOfDoors) {
		if (number < 1) {
			throw new InvalidHallwayNumberException();
		}

		if (numberOfDoors < 1) {
			throw new InvalidDoorsException();
		}

		this.number = number;
		createDoors(numberOfDoors);
	}

	public void openDoor(final int doorNumber) {
		doors.get(doorNumber - 1).open();
	}

	public void closeDoor(final int doorNumber) {
		doors.get(doorNumber - 1).close();
	}

	public void toggleDoor(final int doorNumber) {
		doors.get(doorNumber - 1).toggle();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}

	public Door getDoor(final int doorNumber) {
		return doors.get(doorNumber - 1);
	}

	public List<Door> getDoors() {
		return doors;
	}

	public int getNumberOfOpenDoors() {
		int number = 0;

		for (final Door d : doors) {
			if (d.isOpen()) {
				number++;
			}
		}

		return number;
	}

	public int getNumberOfClosedDoors() {
		int number = 0;

		for (final Door d : doors) {
			if (d.isClosed()) {
				number++;
			}
		}

		return number;
	}

	private void createDoors(final int numberOfDoors) {
		doors = new ArrayList<Door>(numberOfDoors);

		for (int i = 0; i < numberOfDoors; i++) {
			final Door d = new Door();
			d.setNumber(i + 1);
			d.setState(DoorState.CLOSED);
			doors.add(d);
		}
	}

	protected Hallway copy() {
		final Hallway hallway = new Hallway(getNumber(), doors.size());

		getDoors().forEach((Door door) -> {
			final Door copyDoor = hallway.getDoor(door.getNumber());
			copyDoor.setState(door.getState());
		});

		return hallway;
	}
}
