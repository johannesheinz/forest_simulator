package de.johannesheinz.forest_simulator;

import de.johannesheinz.forest_simulator.controller.CameraController;
import de.johannesheinz.forest_simulator.controller.CoordinateAxesController;
import de.johannesheinz.forest_simulator.controller.EventHandler;
import de.johannesheinz.forest_simulator.controller.TreeController;
import de.johannesheinz.forest_simulator.model.Floor;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * The JavaFX main application that combines all controllers.
 *
 * @author Johannes Heinz
 */
public class ForestApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Create a new scene with the size defined in {@link Constants} and a sky blue background.
	 *
	 * @return A new scene
	 */
	private static Scene createScene() {

		Group root = new Group();
		root.getChildren().add(Floor.getInstance());

		Scene scene = new Scene(root, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, true);
		scene.setFill(Color.DEEPSKYBLUE);

		return scene;
	}

	/**
	 * Creates all controllers for a given scene.
	 *
	 * @param scene The scene that the controllers shall belong to
	 */
	private static void createControllers(final Scene scene) {

		TreeController treeController = new TreeController(scene);
		CoordinateAxesController coordinateAxesController = new CoordinateAxesController(scene);
		CameraController cameraController = new CameraController(scene);

		addEventHandlers(scene, treeController, coordinateAxesController, cameraController);
	}

	/**
	 * Maps all event handlers for a given scene and given event handlers.
	 *
	 * @param scene         The scene that shall react on events
	 * @param eventHandlers All relevant event handlers for the scene
	 */
	private static void addEventHandlers(final Scene scene, final EventHandler... eventHandlers) {

		if (eventHandlers != null) {
			scene.setOnKeyPressed(event -> {
				Arrays.stream(eventHandlers).forEach(handler -> handler.handleKeyPressed(event.getCode()));
				event.consume();
			});

			scene.setOnMousePressed(event -> {
				Arrays.stream(eventHandlers).forEach(handler -> handler.handleMousePressed(event));
				event.consume();
			});

			scene.setOnMouseDragged(event -> {
				Arrays.stream(eventHandlers).forEach(handler -> handler.handleMouseDragged(event));
				event.consume();
			});

			scene.setOnScroll(event -> {
				Arrays.stream(eventHandlers).forEach(handler -> handler.handleScroll(event));
				event.consume();
			});
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = createScene();
		createControllers(scene);

		primaryStage.setTitle(Constants.WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
