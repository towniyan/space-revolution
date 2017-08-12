import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import java.util.*;

public class Player extends GameObject {
	public Player (int x, int y) {
		attach(
			new ImageView("/resources/sprites/player.png")
		);
		getAttachment().relocate(x, y);
		SceneHolder.get().addSceneItem(getAttachment());

		new Timer().scheduleAtFixedRate(new TimerTask() {
			public void run () {
				slowDown(1);
			}
		}, 0, 100);
	}

	public void step () {
		move();
		boost();
	}
}