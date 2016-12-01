package de.johannesheinz.forest_simulator.model;

import de.johannesheinz.forest_simulator.Constants;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;

/**
 * A singleton that represents the forest floor.
 *
 * @author Johannes Heinz
 */
public class Floor extends Box {

	private static Floor instance = new Floor();

	private Floor() {

		super();

		setDepth(Constants.FLOOR_WIDTH * 1.15);
		setWidth(Constants.FLOOR_WIDTH * 1.15);
		setHeight(0.1);

		PhongMaterial groundColor = new PhongMaterial();
		groundColor.setDiffuseColor(Color.DARKGREEN);
		groundColor.setSpecularColor(Color.FORESTGREEN);

		setMaterial(groundColor);
		setDrawMode(DrawMode.FILL);
		setOpacity(1.0);

		setTranslateY(0.48 * Constants.FLOOR_WIDTH);
	}
	
	public static Floor getInstance() {
		return instance;
	}
}
