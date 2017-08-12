import java.util.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.event.*;

public abstract class GameBase {
	private StepperThread stepperThread = new StepperThread();
	private boolean running = true;
	private int score = 0;

	public abstract void init ();
	public abstract void step ();

	public GameBase () {
		init();

		Playground.get().getScene().setOnMouseMoved(new EventHandler<MouseEvent> () {
			public void handle (MouseEvent e) {
				onMouseMoved((int) e.getX(), (int) e.getY());
			}
		});

		Playground.get().getScene().setOnKeyPressed(new EventHandler<KeyEvent> () {
			public void handle (KeyEvent e) {
				onKeyPress(e.getCode());
			}
		});
	    
	    stepperThread.start();
	}

	// Getters and setters
	public int getScore () {
		return score;
	}

	public void setRunning (boolean running) {
		this.running = running;
	}

	public boolean isRunning () {
		return running;
	}

	// General
	public void incrementScore () {
		score++;
		((Text) Playground.get().getItem("hud")).setText("" + score);
	}

	public void stop () {
		running = false;
		Playground.get().getScene().setOnMouseMoved(null);
		Playground.get().getScene().setOnKeyPressed(null);

		Playground.get().add("gameover", new Text("GAME OVER WITH " + score + " SCORE!", (Settings.WIDTH / 2) - 120, Settings.HEIGHT / 2));
		Score.save(score);
	}

	public void onKeyPress (KeyCode code) {

	}

	public void onMouseMoved (int x, int y) {

	}
}