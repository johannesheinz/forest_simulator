package de.johannesheinz.forest_simulator.controller;

import de.johannesheinz.forest_simulator.model.CoordinateAxes;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * Event handlers for the {@link CoordinateAxes}.
 *
 * @author Johannes Heinz
 */
public class CoordinateAxesController implements EventHandler {

	private final CoordinateAxes coordinateAxes;

	public CoordinateAxesController(Scene scene) {

		this.coordinateAxes = CoordinateAxes.getInstance();

		Group root = (Group) scene.getRoot();
		root.getChildren().add(coordinateAxes);
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode == KeyCode.X) {
			// Show / Hide coordinate axis
			coordinateAxes.toggleVisibility();
		}
	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		// No handlers for this event
	}

	@Override
	public void handleMouseDragged(MouseEvent event) {
		// No handlers for this event
	}

	@Override
	public void handleScroll(ScrollEvent event) {
		// No handlers for this event
	}
}
