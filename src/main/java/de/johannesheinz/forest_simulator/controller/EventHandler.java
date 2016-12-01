package de.johannesheinz.forest_simulator.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * A uniform interface for event handlers.
 *
 * @author Johannes Heinz
 */
public interface EventHandler {

	void handleKeyPressed(KeyCode keyCode);

	void handleMousePressed(MouseEvent event);

	void handleMouseDragged(MouseEvent event);

	void handleScroll(ScrollEvent event);
}
