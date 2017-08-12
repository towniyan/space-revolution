import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;

public class Rect extends GameObject {
	private int width = 10, height = 10;
	private Color color = Color.web("orange");

	public Rect (int x, int y, int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;

		attach(
			new Rectangle(
				(double) x,
				(double) y,
				(double) width,
				(double) height
			)
		);
		((Rectangle) getAttachment()).setFill(color);
		SceneHolder.get().addSceneItem(getAttachment());
	}

	public void step () {

	}
}