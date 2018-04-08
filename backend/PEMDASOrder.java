package backend;

public class PEMDASOrder {

  private final static int EASY = 0;
  private final static int MED = 0;
  private final static int HARD = 0;

  private int difficulty;
  private String buttonChoice;
  private int range;
  // private int amountNumsInEquation;
  // private MathFlashCard mfc;

  public PEMDASOrder(int difficulty, String buttonChoice) {
    this.buttonChoice = buttonChoice; // button pressed from options
    this.getRange();
    // this.mfc = new MathFlashCard(difficulty);
  }

  public void getRange() {
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
  /*
  public void getAmountNumsInEquation() {
    switch (difficulty) {
      case 1:
        amountNumsInEquation = 3;
        break;
      case 2:
        amountNumsInEquation = 4;
        break;
      case 3:
        amountNumsInEquation = 5;
        break;
      default:
        System.out.println("Invalid difficulty level.
          Cannot determine number of equation numbers.");
        break;
    }
  }
*/
  public int[] numberGenerator(int amountNumsInEquation) {
    int[] equationNums = new int[amountNumsInEquation];
    Random ran = new Random();
    int base = 0;
    switch (this.range) {
      case 10:
        base = 0;
      case 100:
        base = 10;
      case 1000:
        base = 100;
    }
    for (int i = 0; i < equationNums.length; i += 1) {
      equationNums[i] = ran.nextInt(this.range) + base;
    }
    return equationNums;
  }
  /*
  public String calculateAnswer(int[] equationNums) {
    Random ran = new Random();

    for (int i = 0; i < equationNums.length; i += 1) {

    }
    int answer = -1;
    if (equationNums.length == 3) {
      answer = equationNums[0] + equationNums[1] - equationNums[2];
    } else if (equationNums.length == 4) {
      answer = equationNums[0] + equationNums[1]
                - equationNums[2] / equationNums[3];
    } else if (equationNums.length == 5) {
      answer = equationNums[0] + equationNums[1]
                - equationNums[2] / equationNums[3] * equationNums[4];
    }
    return answer;
  }
  */


  public String[] promptGenerator() {
    String[] answerAndPrompt = new String[2];
    String[] operatorList = new String[4];
    // Minimum amount of numbers in equation is 3
    int amountNumsInEquation = ran.nextInt(2) + 3;
    // Generate all numbers in equation
    int[] equationNums = numberGenerator(amountNumsInEquation);
    int answer = -1;
    String answer = "";
    // int[] equationNumsWithAnswer = new int[equationNums.length + 1];
    switch (buttonChoice) {
      case "a":
        // (x * y) + z
        operatorList = {" + "," - ", " / ", " * "};
        System.out.println("PEMDAS Option 'a' chosen.");
        // answer = calculateAnswer(equationNums);
        equationWithEqualSign = equationNums[0];
        for (int i = 1; i < equationNums.length - 1; i += 1) {
          equationWithEqualSign += operatorList[i - 1];
          equationWithEqualSign += equationNums[i];
        }

        switch(equationNums.length) {
          case 3:
            answer = equationNums[0] + equationNums[1] - equationNums[2];
            break;
          case 4:
            answer = equationNums[0] + equationNums[1] - equationNums[2]
                      / equationNums[3];
            break;
          case 5:
            answer = equationNums[0] + equationNums[1] - equationNums[2]
                      / equationNums[3] * equationNums[4];
            break;
          default:
            break;
        }
        equationWithEqualSign += ( " = " );
        break;
      case "b":
        System.out.println("PEMDAS Option 'b' chosen.");

        break;

      case "c":
        System.out.println("PEMDAS Option 'c' chosen.");
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
    answerAndPrompt[1] = equationWithEqualSign;
    return problemToSolve;
  }
}
