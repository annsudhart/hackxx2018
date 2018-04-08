import java.util.*;

public class MathFlashCard {

  /* difficulty levels */
  private static final int EASY = 0;
  private static final int MED = 1;
  private static final int HARD = 2;

  public static int[] add(int difficulty) {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned
    int range = 0; // set the limit of the randomly generated numbers

    if (difficulty == EASY) {
      range = 10;
    } else if (difficulty == MED) {
      range = 100;
    } else if (difficulty == HARD) {
      range = 1000;
    }

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] + arr[1];

    return arr;
  }

  public static int[] subtract(int difficulty) {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned
    int range = 0; // set the limit of the randomly generated numbers

    if (difficulty == EASY) {
      range = 10;
    } else if (difficulty == MED) {
      range = 100;
    } else if (difficulty == HARD) {
      range = 1000;
    }

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] - arr[1];

    return arr;
  }

  public static int[] multiply(int difficulty) {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned
    int range = 0; // set the limit of the randomly generated numbers

    if (difficulty == EASY) {
      range = 10;
    } else if (difficulty == MED) {
      range = 100;
    } else if (difficulty == HARD) {
      range = 1000;
    }

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] * arr[1];

    return arr;
  }

  public static int[] divide(int difficulty) {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned
    int range = 0; // set the limit of the randomly generated numbers

    if (difficulty == EASY) {
      range = 10;
    } else if (difficulty == MED) {
      range = 100;
    } else if (difficulty == HARD) {
      range = 1000;
    }

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] / arr[1];

    return arr;
  }
}
