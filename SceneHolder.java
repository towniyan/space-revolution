import java.util.*;
import javafx.scene.*;
import javafx.css.*;

public class SceneHolder {
	private Group sceneItems = new Group();
	private Scene scene;
	private static SceneHolder sceneHolder;

	public static SceneHolder get () {
		return SceneHolder.sceneHolder;
	}

	public static void set (SceneHolder sceneHolder) {
		SceneHolder.sceneHolder = sceneHolder;
	}

	public Group getSceneItems () {
		return sceneItems;
	}

	public void addSceneItem (Node item) {
		sceneItems.getChildren().add(item);
	}

	public Scene getScene () {
		return this.scene;
	}

	public void setScene (Scene scene) {
		this.scene = scene;
	}
}