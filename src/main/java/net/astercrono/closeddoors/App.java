package net.astercrono.closeddoors;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import net.astercrono.colorgrid.ColorGrid;
import net.astercrono.colorgrid.ColorGridDimensions;

public class App {
	private static final Color OPEN_COLOR = Color.MAGENTA;
	private static final Color CLOSED_COLOR = Color.GRAY;
	
	private SolveHistory history;

	public App(final SolveHistory history) {
		this.history = history;
	}

	public static void main(final String[] args) {
		final int numberOfDoors= 100;
		final int width = 500;
		final int height = 500;

		final DoorSolver solver = new DoorSolver(numberOfDoors);
		final SolveHistory history = solver.solve();

		final App app = new App(history);
		app.render(width, height);
	}

	private void render(final int width, final int height) {
		history.getDoorsPerHallway();
		
		final ColorGridDimensions dimensions = new ColorGridDimensions();
		dimensions.setRows(history.getNumberOfHallways());
		dimensions.setColumns(history.getDoorsPerHallway());
		dimensions.setWidth(width);
		dimensions.setHeight(height);

		final ColorGrid grid = new ColorGrid(dimensions);

		final JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(width, height);
		window.add(grid);
		window.setVisible(true);
		
		history.getHallways().forEach((Hallway hallway) -> {
			renderHallway(hallway, grid);
		});
		grid.repaint();
	}

	private void renderHallway(final Hallway hallway, final ColorGrid grid) {
		List<Color> colors = new ArrayList<Color>(hallway.getDoors().size());
		
		hallway.getDoors().forEach((Door door) -> {
			if (door.isOpen()) {
				colors.add(OPEN_COLOR);
			}
			else {
				colors.add(CLOSED_COLOR);
			}
		});
		
		grid.setRowColors(hallway.getNumber() - 1, colors.toArray(new Color[colors.size()]));
	}
}
