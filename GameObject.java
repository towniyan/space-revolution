import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.geometry.*;

public abstract class GameObject {
	private Node attachment;
	private double[] velocity = {0, 0};
	// private int[] boost = {0, 0, 0};

	public abstract void step ();

	// Getters and setters
	public Node getAttachment () {
		return this.attachment;
	}

	public void attach (Node attachment) {
		this.attachment = attachment;
	}

	public void setVelocity (double[] velocity) {
		this.velocity = velocity;
	}

	public double getX () {
		return attachment.getBoundsInParent().getMinX();
	}

	public double getY () {
		return attachment.getBoundsInParent().getMinY();
	}

	public double getWidth () {
		return (getBounds().getMaxX() - getBounds().getMinX());
	}

	public double getHeight () {
		return (getBounds().getMaxY() - getBounds().getMinY());
	}

	public Bounds getBounds () {
		return attachment.getBoundsInParent();
	}

	// General
	public void move () {
		attachment.setLayoutX(attachment.getLayoutX() + velocity[0]);
		attachment.setLayoutY(attachment.getLayoutY() + velocity[1]);
	}

	public void moveX (double x) {
		attachment.setLayoutX(attachment.getLayoutX() + x);
	}

	public void moveY (double y) {
		attachment.setLayoutY(attachment.getLayoutY() + y);
	}

	public void bounceX () {
		velocity[0] *= -1;
	}

	public void bounceY () {
		velocity[1] *= -1;
	}

	public boolean collidesWith(String go) {
		if (getBounds().intersects(
				Playground.get().getItem(go).getBounds()
			)
		)
			return true;
		return false;
	}

	public boolean collidesWith(GameObject go) {
		if (getBounds().intersects(
				go.getBounds()
			)
		)
			return true;
		return false;
	}

	public void accelerate (int[] components) {
		if (velocity[0] >= 0)
			velocity[0] += components[0];
		else if (velocity[0] < 0)
			velocity[0] -= components[0];

		if (velocity[1] >= 0)
			velocity[1] += components[1];
		else if (velocity[1] < 0)
			velocity[1] -= components[1];
	}

	public void accelerateBlindly (int[] components) {
		velocity[0] += components[0];
		velocity[1] += components[1];
	}

	// public void boost () {
	// 	if (boost[2] > 0) {
	// 		accelerateBlindly(new int[] {boost[0], boost[1]});
	// 		boost[2]--;
	// 	}
	// }

	// public void setBoost (int[] a, int fuel) {
	// 	boost[0] = a[0];
	// 	boost[1] = a[1];
	// 	boost[2] = fuel;
	// }

	public void decelerate (int[] components) {
		if (velocity[0] > 0)
			velocity[0] -= components[0];
		else if (velocity[0] < 0)
			velocity[0] += components[0];

		if (velocity[1] > 0)
			velocity[1] -= components[1];
		else if (velocity[1] < 0)
			velocity[1] += components[1];
	}

	public void slowDown (int intensity) {
		if (velocity[0] > 0)
			velocity[0] -= intensity;
		else if (velocity[0] < 0)
			velocity[0] += intensity;

		if (velocity[1] > 0)
			velocity[1] -= intensity;
		else if (velocity[1] < 0)
			velocity[1] += intensity;
	}

	public static void destroy (GameObject object) {
		for (int i = 0; i < GameObjectsHolder.get().getItems().size(); i++) {
			GameObject go = GameObjectsHolder.get().getItems().get(i);
			if (go.equals(object)) {
				GameObjectsHolder.get().getItems().remove(i);
			}
		}

		for (int i = 0; i < SceneHolder.get().getSceneItems().getChildren().size(); i++) {
			Node node = SceneHolder.get().getSceneItems().getChildren().get(i);
			if (node.equals(object.getAttachment())) {
				SceneHolder.get().getSceneItems().getChildren().remove(i);
			}
		}
	}
}