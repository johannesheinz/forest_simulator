package de.johannesheinz.forest_simulator.model;

import de.johannesheinz.forest_simulator.Constants;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;

/**
 * A singleton that represents the three coordinate axes X, Y and Z.
 *
 * @author Johannes Heinz
 */
public class CoordinateAxes extends Group {

	private static CoordinateAxes instance = new CoordinateAxes();

	private CoordinateAxes() {

		super();

		PhongMaterial blueMaterial = new PhongMaterial();
		blueMaterial.setDiffuseColor(Color.DARKBLUE);
		blueMaterial.setSpecularColor(Color.BLUE);

		PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);

		PhongMaterial greenMaterial = new PhongMaterial();
		greenMaterial.setDiffuseColor(Color.DARKGREEN);
		greenMaterial.setSpecularColor(Color.GREEN);

		getChildren().addAll(
				createAxis(blueMaterial, Constants.AXIS_LENGTH, Rotate.Z_AXIS, 90.0),
				createAxis(redMaterial, Constants.AXIS_LENGTH * 0.45, Rotate.Y_AXIS, 0.0),
				createAxis(greenMaterial, Constants.AXIS_LENGTH, Rotate.X_AXIS, 90.0)
		);

		setVisible(false);
	}
	
	public static CoordinateAxes getInstance() {
		return instance;
	}

	private final Group createAxis(Material material, double height, Point3D rotationAxis, double rotationAngle) {

		Group axis = new Group();

		axis.getChildren().addAll(
				createBar(material, height),
				createArrow(material, height)
		);

		axis.setRotationAxis(rotationAxis);
		axis.setRotate(rotationAngle);
		axis.setTranslateY(Constants.FLOOR_WIDTH / 2);

		return axis;
	}

	private final Cylinder createBar(Material material, double height) {

		Cylinder bar = new Cylinder(Constants.AXIS_RADIUS, height);

		bar.setMaterial(material);
		return bar;
	}

	private final MeshView createArrow(Material material, double translate) {

		TriangleMesh pyramidMesh = new TriangleMesh();
		pyramidMesh.getTexCoords().addAll(0, 0);

		float height = 6.0f * (float) Constants.AXIS_RADIUS;
		float side = 5.0f * (float) Constants.AXIS_RADIUS;

		pyramidMesh.getPoints().addAll(
				0, 0, 0,                // P0: Top
				0, height, -side / 2,   // P1: Front
				-side / 2, height, 0,   // P2: Left
				side / 2, height, 0,    // P3: Back
				0, height, side / 2     // P4: Right
		);

		pyramidMesh.getFaces().addAll(
				0, 0, 2, 0, 1, 0,    // Front left face
				0, 0, 1, 0, 3, 0,    // Front right face
				0, 0, 3, 0, 4, 0,    // Back right face
				0, 0, 4, 0, 2, 0,    // Back left face
				4, 0, 1, 0, 2, 0,    // Bottom rear face
				4, 0, 3, 0, 1, 0     // Bottom front face
		);

		MeshView pyramid = new MeshView(pyramidMesh);

		pyramid.setDrawMode(DrawMode.FILL);
		pyramid.setMaterial(material);

		pyramid.setTranslateY(translate * -0.53);

		return pyramid;
	}

	public void toggleVisibility() {
		setVisible(!isVisible());
	}
}
