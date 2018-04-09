package backend;
/*
 * Name: Abirami Sambamoorthy, Andrea Sudharta, 
 *       Nicole Trappe, Cora Yichen Xing
 * Date: 7 April 2018
 * for HackXX
 */

import java.util.*;

/**
 * This class generates the math questions (and their
 * answers) to be displayed in the program, taking into
 * account difficulty levels and type of math to generate.
 *
 * @author Abirami Sambamoorthy, Andrea Sudharta, 
 *         Nicole Trappe, Cora Yichen Xing
 *
 */

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

    /* generate two numbers to be added/subtracted/etc
     * based on difficulty */

    if (diff == EASY) {
      arr[0] = ran.nextInt(11);
      arr[1] = ran.nextInt(11);

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 11;
      arr[1] = ran.nextInt(90) + 11;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 101;
      arr[1] = ran.nextInt(900) + 101;
    }

    arr[2] = arr[0] + arr[1];

    return arr;
  }

  /**
   * Subtract() 
   * This function generates a subtraction problem.
   *
   * @return an int array containing the two numbers to
   *         subtract and its solution
   */

  public int[] subtract() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    if (diff == EASY) {
      while (true) {
        arr[0] = ran.nextInt(11);
        arr[1] = ran.nextInt(11);
        if (arr[0] >= arr[1]) {
          break;
        }
      }

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 11;
      arr[1] = ran.nextInt(90) + 11;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 101;
      arr[1] = ran.nextInt(900) + 101;
    }

    arr[2] = arr[0] - arr[1];

    return arr;
  }

  /**
   * Multiply() 
   * This function generates a multiplication problem.
   *
   * @return an int array containing the two numbers to
   *         multiply and its solution
   */

  public int[] multiply() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    if (diff == EASY) {
      arr[0] = ran.nextInt(11);
      arr[1] = ran.nextInt(11);

    } else if (diff == MED) {
      arr[0] = ran.nextInt(90) + 11;
      arr[1] = ran.nextInt(90) + 11;

    } else if (diff == HARD) {
      arr[0] = ran.nextInt(900) + 101;
      arr[1] = ran.nextInt(90) + 11;
    }

    arr[2] = arr[0] * arr[1];

    return arr;
  }

  /**
   * Divide() 
   * This function generates a multiplication problem.
   *
   * @return an int array containing the two numbers to
   *         multiply and its solution
   */

  public int[] divide() {
    Random ran = new Random(); // create new Random
    int[] arr = new int[3]; // create array to be returned

    while (true) {
      if (diff == EASY) {
        arr[0] = ran.nextInt(10) + 1;
        arr[1] = ran.nextInt(10) + 1;

      } else if (diff == MED) {
        arr[0] = ran.nextInt(91) + 10;
        arr[1] = ran.nextInt(10) + 1;

      } else if (diff == HARD) {
        arr[0] = ran.nextInt(901) + 100;
        arr[1] = ran.nextInt(91) + 10;
      }

      if (arr[0] % arr[1] == 0) {
        break;
      }
    }
    arr[2] = arr[0] / arr[1];

    return arr;
  }
}
