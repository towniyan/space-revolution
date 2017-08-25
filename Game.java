import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import java.util.*;

public class Game extends GameBase {
	private static Game game;
	private int counter = 0;

	public static void set (Game game) {
		Game.game = game;
	}

	public static Game get () {
		return Game.game;
	}

	public void init () {
		GameObjectsHolder g = GameObjectsHolder.get();

		g.add("player",
			new Player(Settings.WIDTH / 2, Settings.HEIGHT - 100)
		);

		g.add("score",
			new Text("Score: 0", 25, 25)
		);

		g.add("bottom",
			new Rect(0, Settings.HEIGHT, Settings.WIDTH, 1, Color.web("black"))
		);

		// Playground.get().getScene().setCursor(Cursor.NONE);
	}

	public void step () {
		GameObjectsHolder g = GameObjectsHolder.get();
		if (counter == 100) {
			g.add(
				new Enemy(
					100 + 
					100 + (Math.random() * ((Settings.WIDTH - 100) - 100)),
					30
				)
			);
			counter = 0;
		}
		counter++;
	}

	public void onMouseMoved (int x, int y) {
		GameObject player = GameObjectsHolder.get().getItem("player");
		player.getAttachment().relocate(x, player.getY());
	}

	public void onMouseClicked (int x, int y) {
		GameObjectsHolder g = GameObjectsHolder.get();
		GameObject player = g.getItem("player");

		g.add(
			new Bullet(
				(player.getX() + player.getAttachment().getBoundsInParent().getMaxX()) / 2,
				player.getY()
			)
		);
	}
}