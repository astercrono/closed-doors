package net.astercrono.closeddoors;

import java.util.ArrayList;
import java.util.List;

public class DoorSolver {
	private int numberOfDoors;

	public DoorSolver(final int numberOfDoors) {
		if (numberOfDoors < 1) {
			throw new InvalidDoorsException();
		}

		this.numberOfDoors = numberOfDoors;
	}

	public int numberOfDoors() {
		return numberOfDoors;
	}

	public SolveHistory solve() {
		final SolveHistory history = new SolveHistory();
		final List<Hallway> hallways = new ArrayList<Hallway>(numberOfDoors);

		history.setDoorsPerHallway(numberOfDoors);

		for (int row = 1; row <= numberOfDoors; row++) {
			Hallway hallway;

			if (row == 1) {
				hallway = new Hallway(row, numberOfDoors);
			}
			else {
				hallway = hallways.get(row - 2).copy();
				hallway.setNumber(row);
			}
			
			toggleDoors(hallway);
			hallways.add(hallway);
		}

		history.setHallways(hallways);
		history.setNumberOfHallways(hallways.size());

		return history;
	}

	private Hallway toggleDoors(final Hallway hallway) {
		final int hallwayNumber = hallway.getNumber();
		
		for (int doorNumber = hallwayNumber; doorNumber <= numberOfDoors; doorNumber++) {
			if (doorNumber % hallwayNumber == 0) {
				hallway.toggleDoor(doorNumber);
			}
		}

		return hallway;
	}
}
