
public class PEMDASOrder {

  private static int EASY = 0;
  private static int MED = 0;
  private static int HARD = 0;

  private int difficulty;
  private String buttonChoice;
  private int range;
  private int amountNumsInEquation;
  // private MathFlashCard mfc;

  public PEMDASOrder(int difficulty, String buttonChoice) {
    this.buttonChoice = buttonChoice; // button pressed from options
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
  public int[] numberGenerator() {
    int[] equationNums = new int[amountNumsInEquation];
    Random ran = new Random();
    for (int i = 0; i < numEquationNums; i += 1) {
      equationNums[i] = ran.nextInt(this.range);
    }
    return equationNums;
  }

  // TODO EDIT
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
  public String promptGenerator() {
    getAmountNumsInEquation(); // Determine number of equation numbers
    // String[] operatorList = new String[]{" + "," - ", " / ", " * "}; // TODO change order
    int[] equationNums = numberGenerator(); // Generate all numbers in equation
    int answer = -1;
    String equationWithAnswer = "";
    // int[] equationNumsWithAnswer = new int[equationNums.length + 1]; // Added 1 space for answer space
    switch (buttonChoice) {
      case "a":
        // (x * y) + z
        System.out.println("PEMDAS Option 'a' chosen.");
        /* answer = calculateAnswer(equationNums);
          for (int i = 0; i < equationNums.length - 1; i += 1) {
            equationWithAnswer += equationNums[i];
            equationWithAnswer += operatorList[i];
          }
          equationWithAnswer += ( " = " + answer );
        */
        break;
      case "b";
        System.out.println("PEMDAS Option 'b' chosen.");

        break;
      case "c";
        System.out.println("PEMDAS Option 'c' chosen.");
        break;
      case "d";
        System.out.println("PEMDAS Option 'd' chosen.");
        break;
      case "e";
        System.out.println("PEMDAS Option 'e' chosen.");
        break;
      case "f";
        System.out.println("PEMDAS Option 'f' chosen.");
        break;
      case "g";
        System.out.println("PEMDAS Option 'g' chosen.");
        break;
      case "h";
        System.out.println("PEMDAS Option 'h' chosen.");
        break;
      default:
        System.out.println("button choice does not exist");
    }
    return problemToSolve;
  }

  public void orderGenerator() {

  }

    public void orderGeneratorV2() {

    }


}
