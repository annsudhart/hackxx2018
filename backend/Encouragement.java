import java.util.Random;
public class Encouragement {
	
	private final String HYPATIA = "Hypatia c.370 - 415.  She worked " +
	"to teach and preserve Greek mathematics in her time. She was also " +
	"known for her strength in philosophy and reasoning.";
	private final String MARYAM = "Maryam Mirzakhani 1977 - 2017. She won " +
	"the prestigious Fields medal in Mathematics for her research in " +
	"geometry, and was the first woman to win such a medal.";
	private final String AGNESI = "Maria Agnesi 1718 - 1799.  First woman " +
	"professor in a university. One of her most famous inventions was " +
	"an equation known as The Witch of Agnesi.";
	private final String LOVELACE = "Ada Lovelace 1815 - 1852.  Created " +
	"the first programming algorithm, she was a visionary who saw promise " +
	"in computing machinery and built on it.";
	private final String LOFTON = "Euphemia Lofton 1890 - 1980. First " +
	"African American woman to get a Ph. D. in Mathematics, she brought " +
	"mathematics education to children in Washington D.C.\'s public schools.";
	private String[] encouragement={HYPATIA, MARYAM, AGNESI, LOVELACE, LOFTON};

	public Encouragement() {

	}

	// generate a specific String for encouragement
	// pick a string from 0 to 4 inclusive
	public String generateEncouragement(int x) {
		if (x > 0 || x < 5) {
			System.err.println("encouragement out of bounds");
			return "You got this!";
		} else {
			return encouragement[x];
		}
	}

	// generate a random String for encouragement
	public String generateRandomEncouragement() {
		Random r = new Random();
		int index = r.nextInt(5);
		return encouragement[index];
	}

}
