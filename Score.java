import java.io.*;
import java.util.*;

public class Score {
	public static void save (int score) {
		String currentLine, previousLine = null;
		try {
			BufferedReader r = new BufferedReader(
				new FileReader("scores.csv")
			);

			while (true) {
				currentLine = r.readLine();
				if (currentLine != null)
					previousLine = currentLine;
				else
					break;
			}

			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			int id = (previousLine == null) ? 1 : Integer.parseInt(previousLine.split(",")[0].trim()) + 1;

			BufferedWriter w = new BufferedWriter(
				new FileWriter("scores.csv", true)
			);
			w.write(id + ", " + score);
			w.newLine();

			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getScores () {
		ArrayList<String> scores = new ArrayList<String>();

		try {
			String line;

			BufferedReader r = new BufferedReader(
				new FileReader("scores.csv")
			);

			while ((line = r.readLine()) != null) {
				scores.add(line);
			}

			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return scores;
		}
	}
}