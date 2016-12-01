package de.johannesheinz.forest_simulator;

/**
 * The constants that define the behaviour of the JavaFX application.
 *
 * @author Johannes Heinz
 */
public class Constants {

	static final String WINDOW_TITLE = "Forest Simulator";

	static final double SCREEN_WIDTH  = 1400.0;
	static final double SCREEN_HEIGHT = 800.0;

	public static final double FLOOR_WIDTH = 200.0;

	public static final double AXIS_LENGTH = 250.0;
	public static final double AXIS_RADIUS = 1.0;

	public static final double DEFAULT_MULTIPLIER = 1.0;
	public static final double CONTROL_MULTIPLIER = 0.1;
	public static final double SHIFT_MULTIPLIER   = 10.0;

	public static final double CAMERA_ZOOM_DEFAULT = 1.0;

	public static final double CAMERA_ZOOM_IN_DEFAULT = 1.07;
	public static final double CAMERA_ZOOM_IN_SLOW    = 1.01;
	public static final double CAMERA_ZOOM_IN_FAST    = 1.2;

	public static final double CAMERA_ZOOM_OUT_DEFAULT = 0.93;
	public static final double CAMERA_ZOOM_OUT_SLOW    = 0.99;
	public static final double CAMERA_ZOOM_OUT_FAST    = 0.8;

	public static final double CAMERA_ROTATION_SPEED = 0.2;
}
