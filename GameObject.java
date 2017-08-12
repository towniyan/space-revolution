import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.geometry.*;

public abstract class GameObject {
	private Shape shape;
	private Node node;
	private int[] velocity = {0, 0};

	public abstract void step ();

	// Getters and setters
	public Shape getShape () {
		return this.shape;
	}

	public void setShape (Shape shape) {
		this.shape = shape;
	}
	public Node getNode () {
		return this.node;
	}

	public void setNode (Node node) {
		this.node = node;
	}

	public void setVelocity (int[] velocity) {
		this.velocity = velocity;
	}

	public int getX () {
		return (int) shape.getBoundsInParent().getMinX();
	}

	public int getY () {
		return (int) shape.getBoundsInParent().getMinY();
	}

	public int getWidth () {
		return (int) (getBounds().getMaxX() - getBounds().getMinX());
	}

	public int getHeight () {
		return (int) (getBounds().getMaxY() - getBounds().getMinY());
	}

	public Bounds getBounds () {
		return shape.getBoundsInParent();
	}

	// General
	public void move () {
		shape.setLayoutX(shape.getLayoutX() + velocity[0]);
		shape.setLayoutY(shape.getLayoutY() + velocity[1]);
		// shape.relocate(this.shape.translateX, this.shape.translateY);
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

	public void accelerate (int[] components) {
		if (velocity[0] > 0)
			velocity[0] += components[0];
		else if (velocity[0] < 0)
			velocity[0] -= components[0];

		if (velocity[1] > 0)
			velocity[1] += components[1];
		else if (velocity[1] < 0)
			velocity[1] -= components[1];
	}
}