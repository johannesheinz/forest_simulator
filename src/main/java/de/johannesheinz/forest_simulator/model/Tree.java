package de.johannesheinz.forest_simulator.model;

import de.johannesheinz.forest_simulator.Constants;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.Random;

/**
 * Model of a tree that consists of three intersecting planes.
 *
 * @author Johannes Heinz
 */
public class Tree extends Group {

	private static Random random = new Random();

	// The texture is taken from:
	// http://media-curse.cursecdn.com/attachments/120/452/1d989ce82aa50be696a668a614ffb84a.png
	private static Image treeTexture = new Image(Tree.class.getClassLoader().getResourceAsStream("texture.png"));

	public Tree() {

		double scale = 0.35 + 0.65 * random.nextDouble();

		// Max height: 30 meters
		// Width is derived from the texture's properties: 162px x 200px
		double width = 26.4 * scale;
		double height = 32.6 * scale;

		this.getChildren().addAll(
				createNewTree(width, height, 0.0),
				createNewTree(width, height, 60.0),
				createNewTree(width, height, 120.0)
		);

		double xPosition = random.nextDouble() * Constants.FLOOR_WIDTH;
		double zPosition = random.nextDouble() * Constants.FLOOR_WIDTH;

		setTranslateX(xPosition - (Constants.FLOOR_WIDTH / 2));
		setTranslateY((Constants.FLOOR_WIDTH / 2) - height);
		setTranslateZ(zPosition - (Constants.FLOOR_WIDTH / 2));
	}

	/**
	 * Create one of the three sides of a new tree.
	 *
	 * @param width         Width of the new tree
	 * @param height        Height of the new tree
	 * @param rotationAngle Rotation of the new tree
	 * @return A plane that represents one side of a tree
	 */
	private Rectangle createNewTree(double width, double height, double rotationAngle) {

		Rectangle rectangle = new Rectangle(width, height);

		rectangle.setFill(new ImagePattern(treeTexture, 0, 0, 1, 1, true));
		rectangle.setSmooth(false);

		rectangle.getTransforms().addAll(
				new Rotate(
						rotationAngle,
						width / 2,
						0.0,
						0.0,
						Rotate.Y_AXIS
				)
		);
		return rectangle;
	}
}
