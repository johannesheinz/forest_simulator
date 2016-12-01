package de.johannesheinz.forest_simulator.model;

import de.johannesheinz.forest_simulator.Constants;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * A singleton that represents the camera on the 3D scene.
 *
 * @author Johannes Heinz
 */
public class Camera extends PerspectiveCamera {

	private static Camera instance = new Camera();

	private Rotate    cameraRotateX;
	private Rotate    cameraRotateY;
	private Rotate    cameraRotateZ;
	private Translate cameraTranslate;

	private Camera() {

		super(true);

		setFieldOfView(35.0);
		setNearClip(0.1);
		setFarClip(100000.0);

		cameraRotateX = new Rotate(0.0, Rotate.X_AXIS);
		cameraRotateY = new Rotate(0.0, Rotate.Y_AXIS);
		cameraRotateZ = new Rotate(0.0, Rotate.Z_AXIS);
		cameraTranslate = new Translate(0.0, 0.0, 0.0);

		getTransforms().addAll(
				cameraRotateY,
				cameraRotateX,
				cameraRotateZ,
				cameraTranslate
		);
		resetView();
	}

	public static Camera getInstance() {
		return instance;
	}

	public void rotate(double angleX, double angleY) {
		cameraRotateX.setAngle(angleX);
		cameraRotateY.setAngle(angleY);
	}

	private void rotate(double angleX, double angleY, double angleZ) {
		cameraRotateX.setAngle(angleX);
		cameraRotateY.setAngle(angleY);
		cameraRotateZ.setAngle(angleZ);
	}

	private void translate(double translateX, double translateY, double translateZ) {
		cameraTranslate.setX(translateX);
		cameraTranslate.setY(translateY);
		cameraTranslate.setZ(translateZ);
	}

	public void zoomIn() {
		setScaleX(Constants.CAMERA_ZOOM_IN * getScaleX());
		setScaleY(Constants.CAMERA_ZOOM_IN * getScaleY());
		setScaleZ(Constants.CAMERA_ZOOM_IN * getScaleZ());
	}

	public void zoomOut() {
		setScaleX(Constants.CAMERA_ZOOM_OUT * getScaleX());
		setScaleY(Constants.CAMERA_ZOOM_OUT * getScaleY());
		setScaleZ(Constants.CAMERA_ZOOM_OUT * getScaleZ());
	}

	private void resetZoom() {
		setScaleX(Constants.CAMERA_ZOOM_DEFAULT);
		setScaleY(Constants.CAMERA_ZOOM_DEFAULT);
		setScaleZ(Constants.CAMERA_ZOOM_DEFAULT);
	}

	public double getAngleX() {
		return cameraRotateX.getAngle();
	}

	public double getAngleY() {
		return cameraRotateY.getAngle();
	}

	public void resetView() {
		rotate(-10.0, -35.0, 0.0);
		translate(20.0, 65.0, -1.8 * Constants.FLOOR_WIDTH);
		resetZoom();
	}

	public void setToFrontView() {
		translate(0.0, 100.0, -1.8 * Constants.FLOOR_WIDTH);
		rotate(0.0, 0.0, 0.0);
		resetZoom();
	}

	public void setToTopView() {
		translate(0.0, 0.0, -400.0);
		rotate(-90.0, 0.0, 0.0);
		resetZoom();
	}
}
