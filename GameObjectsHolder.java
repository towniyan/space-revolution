import java.util.*;
import javafx.scene.*;
import javafx.css.*;

public class GameObjectsHolder {
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	private static GameObjectsHolder gameObjectsHolder;
	private HashMap<String, GameObject> itemsHashed = new HashMap<String, GameObject>();

	public static GameObjectsHolder get () {
		return GameObjectsHolder.gameObjectsHolder;
	}

	public static void set (GameObjectsHolder gameObjectsHolder) {
		GameObjectsHolder.gameObjectsHolder = gameObjectsHolder;
	}

	public ArrayList<GameObject> getItems () {
		return items;
	}

	public GameObject getItem (int i) {
		return items.get(i);
	}

	public GameObject getItem (String name) {
		return itemsHashed.get(name);
	}

	public void add (String name, GameObject go) {
		items.add(go);
		itemsHashed.put(name, go);
	}
}