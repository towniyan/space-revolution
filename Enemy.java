import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import java.util.*;

public class Enemy extends GameObject {
	public Enemy (double x, double y) {
		attach(
			new ImageView("/resources/sprites/enemy.png")
		);
		getAttachment().relocate(x, y);
		SceneHolder.get().addSceneItem(getAttachment());

		setVelocity(new double[] {0, 1.5});
	}

	public void step () {
		move();

		for (int i = 0; i < GameObjectsHolder.get().getItems().size(); i++) {
			GameObject go = GameObjectsHolder.get().getItems().get(i);
			if (go instanceof Bullet) {
				if (collidesWith(go)) {
					GameObject.destroy(GameObjectsHolder.get().getItems().get(i));
					GameObject.destroy(this);
					Score.score++;

					((Text) GameObjectsHolder.get().getItem("score")).setText("Score: " + Score.score);
				}
			}
		}

		if (collidesWith(GameObjectsHolder.get().getItem("bottom"))) {
			Score.save(Score.score);
			System.exit(0);
		}
	}
}