import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;

public class Box extends GameObject {
	private int width = 10, height = 10;
	private Color color = Color.web("orange");

	public Box (int x, int y, int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;

		setShape(
			new Rectangle(
				(double) x,
				(double) y,
				(double) width,
				(double) height
			)
		);
		getShape().setFill(color);
		Playground.get().addSceneItem(getShape());
	}

	public void step () {
		// if (getShape().getBoundsInParent().intersects())
	}
}