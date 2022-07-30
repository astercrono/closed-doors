package net.astercrono.closeddoors;

import org.junit.Assert;
import org.junit.Test;

public class DoorSolverTest {
	@Test
	public void testDoorSolver() {
		final int numberOfDoors = 4;

		final DoorSolver solver = new DoorSolver(numberOfDoors);
		final SolveHistory history = solver.solve();

		Assert.assertNotNull(history);
		Assert.assertEquals(numberOfDoors, history.getDoorsPerHallway());
		Assert.assertEquals(numberOfDoors, history.getNumberOfHallways());

		testHistory(history);
	}

	private void testHistory(final SolveHistory history) {
		Assert.assertNotNull(history.getHallways());
		Assert.assertEquals(history.getNumberOfHallways(), history.getHallways().size());

		history.getHallways().forEach((Hallway hallway) -> {
			Assert.assertNotNull(hallway.getDoors());
			Assert.assertEquals(history.getDoorsPerHallway(), hallway.getDoors().size());
			testHallway(hallway);
		});
	}

	private void testHallway(final Hallway hallway) {
		hallway.getDoors().forEach((Door door) -> {
			testDoor(door, hallway.getNumber());
		});
	}

	private void testDoor(final Door door, final int hallwayNumber) {
		final int doorNumber = door.getNumber();

		if (hallwayNumber == 1) {
			Assert.assertTrue(door.isOpen());
		} else if (hallwayNumber == 2) {
			if (doorNumber == 1) {
				Assert.assertTrue(door.isOpen());
			} else if (doorNumber == 2) {
				Assert.assertTrue(door.isClosed());
			} else if (doorNumber == 3) {
				Assert.assertTrue(door.isOpen());
			} else if (doorNumber == 4) {
				Assert.assertTrue(door.isClosed());
			}
		} else if (hallwayNumber == 3) {
			if (doorNumber == 1) {
				Assert.assertTrue(door.isOpen());
			} else if (doorNumber == 2) {
				Assert.assertTrue(door.isClosed());
			} else if (doorNumber == 3) {
				Assert.assertTrue(door.isClosed());
			} else if (doorNumber == 4) {
				Assert.assertTrue(door.isClosed());
			}
		} else {
			if (doorNumber == 1) {
				Assert.assertTrue(door.isOpen());
			} else if (doorNumber == 2) {
				Assert.assertTrue(door.isClosed());
			} else if (doorNumber == 3) {
				Assert.assertTrue(door.isClosed());
			} else if (doorNumber == 4) {
				Assert.assertTrue(door.isOpen());
			}
		}
	}
}
