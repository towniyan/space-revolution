import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;

public class Ball extends GameObject {
	private int size = 10;
	private Color color = Color.web("orange");
	private Shape shape;

	public Ball (int x, int y, int size, Color color) {
		this.size = size;
		this.color = color;

		setShape(new Circle(x, y, size, color));
		Playground.get().addSceneItem(getShape());
	}

	public void step () {
		if (collidesWith("paddle") || collidesWith("top")) {
			bounceY();
			Game.get().incrementScore();
		}
		if (collidesWith("left") || collidesWith("right")) {
			bounceX();
			Game.get().incrementScore();
		}

		if (getBounds().getMaxY() > Settings.HEIGHT)
			Game.get().stop();

		move();
	}
}