import java.util.*;
import javafx.scene.*;
import javafx.css.*;

public class Playground {
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	private Group sceneItems = new Group();
	private Scene scene;
	private static Playground playground;
	private HashMap<String, GameObject> itemsHashed = new HashMap<String, GameObject>();

	public static Playground get () {
		return Playground.playground;
	}

	public static void set (Playground playground) {
		Playground.playground = playground;
	}

	public ArrayList<GameObject> getItems () {
		return items;
	}

	public Group getSceneItems () {
		return sceneItems;
	}

	public void addSceneItem (Node item) {
		sceneItems.getChildren().add(item);
	}

	public GameObject getItem (int i) {
		return items.get(i);
	}

	public GameObject getItem (String name) {
		return itemsHashed.get(name);
	}

	public int size () {
		return items.size();
	}

	public void add (String name, GameObject go) {
		items.add(go);
		itemsHashed.put(name, go);
		// sceneItems.getChildren().add(go);
	}

	public Scene getScene () {
		return this.scene;
	}

	public void setScene (Scene scene) {
		this.scene = scene;
	}
}