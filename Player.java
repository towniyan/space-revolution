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

		for (int i = 0; i < GameObjectsHolder.get().getItems().size(); i++) {
			GameObject go = GameObjectsHolder.get().getItems().get(i);
			if (go instanceof Enemy) {
				if (collidesWith(go)) {
					Score.save(Score.score);
					System.exit(0);
				}
			}
		}
	}

	public void step () {
		move();
	}
}