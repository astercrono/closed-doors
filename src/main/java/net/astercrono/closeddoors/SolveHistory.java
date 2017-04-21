package net.astercrono.closeddoors;

import java.util.List;

public class SolveHistory {
	private int doorsPerHallway;
	private int numberOfHallways;
	private List<Hallway> hallways;

	public int getDoorsPerHallway() {
		return doorsPerHallway;
	}

	public void setDoorsPerHallway(int doorsPerHallway) {
		this.doorsPerHallway = doorsPerHallway;
	}

	public int getNumberOfHallways() {
		return numberOfHallways;
	}

	public void setNumberOfHallways(int numberOfHallways) {
		this.numberOfHallways = numberOfHallways;
	}

	public List<Hallway> getHallways() {
		return hallways;
	}

	public void setHallways(List<Hallway> hallways) {
		this.hallways = hallways;
	}
}
