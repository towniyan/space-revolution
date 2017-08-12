import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import java.util.*;

public class Game extends GameBase {
	private static Game game;

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

		// Playground.get().getScene().setCursor(Cursor.NONE);
	}

	public void step () {
		
	}

	public void onKeyPress (KeyCode code) {
		GameObject player = GameObjectsHolder.get().getItem("player");
		switch (code) {
			case W:
				player.setBoost(new int[]{0, -2}, 1);
				break;
			case S:
				player.setBoost(new int[]{0, 2}, 1);
				break;
			case A:
				player.setBoost(new int[]{-2, 0}, 1);
				break;
			case D:
				player.setBoost(new int[]{2, 0}, 1);
				break;
		}
	}

	public void onMouseMoved (int x, int y) {
		GameObject player = GameObjectsHolder.get().getItem("player");
		player.getAttachment().relocate(x, player.getY());
	}
}