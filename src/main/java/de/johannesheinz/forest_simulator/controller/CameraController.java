package de.johannesheinz.forest_simulator.controller;

import de.johannesheinz.forest_simulator.Constants;
import de.johannesheinz.forest_simulator.model.Camera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * Event handlers for the {@link Camera}.
 *
 * @author Johannes Heinz
 */
public class CameraController implements EventHandler {

	private final Camera camera;

	private double mousePosX;
	private double mousePosY;

	public CameraController(Scene scene) {

		this.camera = Camera.getInstance();
		scene.setCamera(camera);
	}

	@Override
	public void handleKeyPressed(KeyCode keyCode) {

		switch (keyCode) {
			case R:
				// Reset camera to initial perspective
				camera.resetView();
				break;

			case F:
				// Set camera to front view
				camera.setToFrontView();
				break;

			case T:
				// Set camera to front perspective
				camera.setToTopView();
				break;

			default:
				// No default key handler
				break;
		}
	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		// Save Position for delta calculation in handleMouseDragged()
		mousePosX = event.getSceneX();
		mousePosY = event.getSceneY();
	}

	@Override
	public void handleMouseDragged(MouseEvent event) {

		double mouseDeltaX = (event.getSceneX() - mousePosX);
		double mouseDeltaY = (event.getSceneY() - mousePosY);

		mousePosX = event.getSceneX();
		mousePosY = event.getSceneY();

		double modifier = Constants.DEFAULT_MULTIPLIER;

		if (event.isControlDown()) {
			modifier = Constants.CONTROL_MULTIPLIER;

		} else if (event.isShiftDown()) {
			modifier = Constants.SHIFT_MULTIPLIER;
		}

		if (event.isPrimaryButtonDown()) {
			camera.rotate(
					camera.getAngleX() + mouseDeltaY * modifier * Constants.CAMERA_ROTATION_SPEED,
					camera.getAngleY() - mouseDeltaX * modifier * Constants.CAMERA_ROTATION_SPEED
			);
		}
	}

	@Override
	public void handleScroll(ScrollEvent event) {

		if (event.getDeltaY() < 0) {
			camera.zoomOut();

		} else {
			camera.zoomIn();
		}
	}
}
