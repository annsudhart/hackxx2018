/*
 * Name: Abirami Sambamoorthy
 * Date: 7 April 2018
 */

import java.util.*;

public class MathFlashCard {

  /* difficulty levels */
  private static final int EASY = 0;
  private static final int MED = 1;
  private static final int HARD = 2;

  private int range; // set the limit of the randomly generated numbers

  public MathFlashCard(int difficulty) {
    if (difficulty == EASY) {
      range = 10;
    } else if (difficulty == MED) {
      range = 100;
    } else if (difficulty == HARD) {
      range = 1000;
    }
  }

  public int[] add() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] + arr[1];

    return arr;
  }

  public int[] subtract() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] - arr[1];

    return arr;
  }

  public int[] multiply() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] * arr[1];

    return arr;
  }

  public int[] divide() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    arr[0] = ran.nextInt(range);
    arr[1] = ran.nextInt(range);
    arr[2] = arr[0] / arr[1];

    return arr;
  }
}
