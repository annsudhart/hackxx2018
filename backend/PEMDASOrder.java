package backend;
import java.util.Random;

public class PEMDASOrder {

  private final static int EASY = 0;
  private final static int MED = 1;
  private final static int HARD = 2;

  private int difficulty;
  private String buttonChoice;
  private int range;
  // private int amountNumsInEquation;
  // private MathFlashCard mfc;

  public PEMDASOrder(int difficulty, String buttonChoice) {
    this.difficulty = difficulty;
    this.buttonChoice = buttonChoice; // button pressed from options
    this.getRange();
    // this.mfc = new MathFlashCard(difficulty);
  }

  public void getRange() {
    System.out.println(this.difficulty);
    switch (this.difficulty) {
      case EASY:
        this.range = 10;
        break;
      case MED:
        this.range = 100;
        break;
      case HARD:
        this.range = 1000;
        break;
      default:
        System.out.println("Invalid difficulty level. Cannot determine range.");
        break;
    }
  }

  public int[] numberGenerator(int amountNumsInEquation) {
    int[] equationNums = new int[amountNumsInEquation];
    Random ran = new Random();
    int base = 0;
    switch (this.range) {
      case 10:
        base = 1;
        break;
      case 100:
        base = 10;
        break;
      case 1000:
        base = 100;
        break;
      default:
        break;
    }
    for (int i = 0; i < equationNums.length; i += 1) {
      equationNums[i] = ran.nextInt(this.range) + base;
      // System.out.println("base: " + base);
    }
    System.out.println("Generated random numbers");
    printIntArrayNums(equationNums);
    return equationNums;
  }

  public void printIntArrayNums(int[] equationNums) {
    System.out.println();
    System.out.print("Numbers: " );
    for(int i = 0; i < equationNums.length; i += 1) {
      System.out.print( equationNums[i] + " ");
    }
    System.out.println();
  }

  public String[] promptGenerator() {
    String[] answerAndPrompt = new String[2];
    String[] operatorList = new String[]{" + "," - ", " / ", " * "};
    // Minimum amount of numbers in equation is 3
    Random ran = new Random();
    int amountNumsInEquation = ran.nextInt(2) + 3;
    // Generate all numbers in equation
    int[] equationNums = numberGenerator(amountNumsInEquation);
    String equationStr = "";
    String answer = "";
    // int[] equationNumsWithAnswer = new int[equationNums.length + 1];
    switch (buttonChoice) {
      case "a":
        // (x * y) + z
        System.out.println("PEMDAS Option 'a' chosen.");
        // answer = calculateAnswer(equationNums);

        switch(equationNums.length) {
          case 3:
            answer += equationNums[0] + equationNums[1] - equationNums[2];
            break;
          case 4:
            while (equationNums[2] % equationNums[3] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] + equationNums[1] - equationNums[2]
                      / equationNums[3];
            break;
          case 5:
            while (equationNums[2] % equationNums[3] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] + equationNums[1] - equationNums[2]
                      / equationNums[3] * equationNums[4];
            break;
          default:
            break;
        }
        equationStr += equationNums[0];
        for (int i = 1; i < equationNums.length; i += 1) {
          equationStr += operatorList[i - 1];
          equationStr += equationNums[i];
        }
        // equationWithEqualSign += ( " = " );
        break;
      case "b":
        System.out.println("PEMDAS Option 'b' chosen.");
        operatorList = new String[]{" / ", " - ", " + ", " * "};

        switch(equationNums.length) {
          case 3:
            while (equationNums[0] % equationNums[1] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] / equationNums[1] - equationNums[2];
            break;
          case 4:
            while (equationNums[0] % equationNums[1] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] / equationNums[1] - equationNums[2]
                      + equationNums[3];
            break;
          case 5:
            while (equationNums[0] % equationNums[1] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] / equationNums[1] - equationNums[2]
                      + equationNums[3] * equationNums[4];
            break;
          default:
            break;
        }
        equationStr += equationNums[0];
        for (int i = 1; i < equationNums.length; i += 1) {
          equationStr += operatorList[i - 1];
          equationStr += equationNums[i];
        }
        break;

      case "c":
        System.out.println("PEMDAS Option 'c' chosen.");

        operatorList = new String[]{" - ", " * ", " + ", " / "};

        switch(equationNums.length) {
          case 3:
            answer += equationNums[0] - equationNums[1] * equationNums[2];
            break;
          case 4:
            answer += equationNums[0] - equationNums[1] * equationNums[2]
                      + equationNums[3];
            break;
          case 5:
            while (equationNums[3] % equationNums[4] != 0) {
              equationNums = numberGenerator(amountNumsInEquation);
            }
            answer += equationNums[0] - equationNums[1] * equationNums[2]
                      + equationNums[3] / equationNums[4];
            break;
          default:
            break;
        }
        equationStr += equationNums[0];
        for (int i = 1; i < equationNums.length; i += 1) {
          equationStr += operatorList[i - 1];
          equationStr += equationNums[i];
        }
        break;

      case "d":
        System.out.println("PEMDAS Option 'd' chosen.");
        break;

      case "e":
        System.out.println("PEMDAS Option 'e' chosen.");
        break;

      case "f":
        System.out.println("PEMDAS Option 'f' chosen.");
        break;

      case "g":
        System.out.println("PEMDAS Option 'g' chosen.");
        break;

      case "h":
        System.out.println("PEMDAS Option 'h' chosen.");
        break;

      default:
        System.out.println("button choice does not exist");
    }
    answerAndPrompt[0] = answer;
    System.out.println("answer: " + answer);
    answerAndPrompt[1] = equationStr;
    System.out.println("equationStr: " + equationStr);
    return answerAndPrompt;
  }
}
