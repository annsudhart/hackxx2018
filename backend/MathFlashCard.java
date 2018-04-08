package backend;
/*
 * Name: Abirami Sambamoorthy
 * Date: 7 April 2018
 * for HackXX
 */

import java.util.*;

public class MathFlashCard {

  /* difficulty levels */
  private static final int EASY = 0;
  private static final int MED = 1;
  private static final int HARD = 2;

  private int diff;

  public MathFlashCard(int difficulty) {
    this.diff = difficulty;
  }

  public int[] add() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    if (diff == EASY) {
      arr[0] = ran.nextInt(10);
      arr[1] = ran.nextInt(10);

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 10;
      arr[1] = ran.nextInt(90) + 10;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 100;
      arr[1] = ran.nextInt(900) + 100;
    }

    arr[2] = arr[0] + arr[1];

    return arr;
  }

  public int[] subtract() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    if (diff == EASY) {
      while (true) {
        arr[0] = ran.nextInt(10);
        arr[1] = ran.nextInt(10);
        if (arr[0] >= arr[1]) {
          break;
        }
      }

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 10;
      arr[1] = ran.nextInt(90) + 10;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 100;
      arr[1] = ran.nextInt(900) + 100;
    }

    arr[2] = arr[0] - arr[1];

    return arr;
  }

  public int[] multiply() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    if (diff == EASY) {
      arr[0] = ran.nextInt(10);
      arr[1] = ran.nextInt(10);

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 10;
      arr[1] = ran.nextInt(90) + 10;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 100;
      arr[1] = ran.nextInt(900) + 100;
    }

    arr[2] = arr[0] * arr[1];

    return arr;
  }

  public int[] divide() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    while (true) {
      if (diff == EASY) {
        arr[0] = ran.nextInt(9) + 1;
        arr[1] = ran.nextInt(9) + 1;

      } else if (diff == MED) {
        arr[0] = ran.nextInt(90) + 10;
        arr[1] = ran.nextInt(9) + 1;

      } else if (diff == HARD) {
        arr[0] = ran.nextInt(900) + 100;
        arr[1] = ran.nextInt(90) + 10;
      }
 
      if (arr[0] % arr[1] == 0) {
        break;
      }
    }
    arr[2] = arr[0] / arr[1];

    return arr;
  }
}
