import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;

public class Bullet extends GameObject {
	private Color color = Color.web("red");

	public Bullet (double x, double y) {
		attach(
			new Rectangle(
				x,
				y,
				2,
				6
			)
		);
		((Rectangle) getAttachment()).setFill(color);
		SceneHolder.get().addSceneItem(getAttachment());
		setVelocity(new double[] {0, -3});
	}

	public void step () {
		move();
	}
}