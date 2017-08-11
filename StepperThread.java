import javafx.animation.*;

public class StepperThread extends Thread {
	public void run () {
		new AnimationTimer () {
			Playground playground = Playground.get();

			public void handle(long now) {
				if (Game.get().isRunning()) {
					for (int i = 0; i < playground.size(); i++) {
						playground.getItem(i).step();
					}

					Game.get().step();
				}
			}
		}.start();
	}
}