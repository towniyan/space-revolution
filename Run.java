import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.event.*;

public class Run extends Application {
	public void start (Stage stage) {
		menu(stage);
		stage.show();
	}

	public void stop () {
		System.exit(0);
	}

	public void menu (Stage stage) {
		// buttons
		ImageView play = new ImageView("/resources/sprites/play.png");
		ImageView scores = new ImageView("/resources/sprites/scores.png");
		ImageView quit = new ImageView("/resources/sprites/quit.png");

		play.setOnMouseClicked ((MouseEvent e) -> {
			play(stage);
		});
		scores.setOnMouseClicked ((MouseEvent e) -> {
			scores(stage);
		});
		quit.setOnMouseClicked ((MouseEvent e) -> {
			stop();
		});

		// Layout
		VBox items = new VBox(
			20,
			play,
			scores,
			quit
		);
		items.setAlignment(Pos.CENTER);

		// Scene
		stage.setScene(
			new Scene(
				items,
				Settings.WIDTH / 2,
				Settings.HEIGHT / 2,
				Settings.BACKGROUND
			)
		);

		// scores(stage);
	}

	public void play (Stage stage) {
		Playground.set(new Playground());
		Playground.get().setScene(
			new Scene(
				Playground.get().getSceneItems(),
				Settings.WIDTH,
				Settings.HEIGHT,
				Settings.BACKGROUND
			)
		);

		stage.setScene(
			Playground.get().getScene()
		);

		Game.set(new Game());
	}

	public void scores (Stage stage) {
		// Button "Go back"
		Button goBack = new Button("Go back");
		goBack.setOnMouseClicked(new EventHandler<MouseEvent> () {
			public void handle (MouseEvent e) {
				menu(stage);
			}
		});

		// Label "Highscore"
		Label highscore = new Label("Scores");
		highscore.setFont(
			new Font("Arial", (double) 30)
		);
		highscore.setTextFill(Color.web("#0d60e5"));

		// Layout
		VBox items = new VBox (highscore, goBack);
		items.setAlignment(Pos.CENTER);

		// Show the scores
		Label label;
		int id, score;
		for (int i = 0; i < Score.getScores().size(); i++) {
			id = Integer.parseInt(Score.getScores().get(i).split(",")[0].trim());
			score = Integer.parseInt(Score.getScores().get(i).split(",")[1].trim());

			label = new Label(id + ". " + score);
			label.setFont(
				new Font("Arial", (double) 20)
			);

			items.getChildren().add(
				label
			);
		}

		stage.setScene(
			new Scene(
				items,
				Settings.WIDTH / 2,
				Settings.HEIGHT / 2,
				Settings.BACKGROUND
			)
		);
	}
}