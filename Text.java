import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.css.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class Text extends GameObject {
	private Label label;

	public Text (String content, int x, int y) {
		label = new Label(content);
		label.relocate(x, y);
		label.setFont(new Font("Arial", (double) 20));
		label.setTextFill(Color.web("white"));

		Playground.get().addSceneItem(label);
	}

	public void setText (String text) {
		label.setText(text);
	}

	public void step () {

	}
}