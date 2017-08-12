import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
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
		Playground.get().add("ball",
			new Ball(
				50, 50, 10, Color.web("orange")
			)
		);

		Playground.get().add("top",
			new Box(
				0, 0, Settings.WIDTH, 10, Color.web("yellow")
			)
		);

		Playground.get().add("left",
			new Box(
				0, 10, 10, Settings.HEIGHT - 10, Color.web("yellow")
			)
		);

		Playground.get().add("right",
			new Box(
				Settings.WIDTH - 10, 10, 10, Settings.HEIGHT - 10, Color.web("yellow")
			)
		);

		Playground.get().add("paddle",
			new Box(
				Settings.WIDTH / 2, Settings.HEIGHT - 30, 100, 15, Color.web("pink")
			)
		);

		Playground.get().add("hud",
			new Text("" + getScore(), Settings.WIDTH - 50, 20)
		);

		Playground.get().getItem("ball").setVelocity(new int[]{5, 5});

		new Timer().scheduleAtFixedRate(new TimerTask () {
			public void run () {
				Playground.get().getItem("ball").accelerate(new int[]{1, 1});
			}
		}, 0, 2000);
	}

	public void step () {
		
	}

	public void onKeyPress (KeyCode code) {
		
	}

	public void onMouseMoved (int x, int y) {
		if (x >= 10 && x <= Settings.WIDTH - Playground.get().getItem("paddle").getWidth() - 10)
			Playground.get().getItem("paddle").getShape().relocate(x, Playground.get().getItem("paddle").getY());
	}
}