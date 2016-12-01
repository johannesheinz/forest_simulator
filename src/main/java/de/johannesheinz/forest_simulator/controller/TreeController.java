package de.johannesheinz.forest_simulator.controller;

import de.johannesheinz.forest_simulator.model.Tree;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * Event handlers for the {@link Tree}.
 *
 * @author Johannes Heinz
 */
public class TreeController implements EventHandler {

	private final Scene scene;

	public TreeController(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		if (keyCode == KeyCode.SPACE) {
			// Plant new tree
			Group root = (Group) scene.getRoot();
			root.getChildren().add(new Tree());
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
