import javafx.animation.*;

public class StepperThread extends Thread {
	public void run () {
		new AnimationTimer () {
			GameObjectsHolder g = GameObjectsHolder.get();

			public void handle(long now) {
				if (Game.get().isRunning()) {
					for (int i = 0; i < g.getItems().size(); i++) {
						g.getItem(i).step();
					}

					Game.get().step();
				}
			}
		}.start();
	}
}