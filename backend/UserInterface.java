package backend;
/*
 * Name: Nicole Trappe
 * Hackathon, Spring '18
 * Date: 7 April 2018
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JPanel implements ActionListener
{
    private static int LVL_EASY = 0;
    private static int LVL_MEDIUM = 1;
    private static int LVL_HARD = 2;
    private int current_level = -1; // the current difficulty lvl

    private static int OP_ADD = 0;
    private static int OP_SUBTRACT = 1;
    private static int OP_MULTIPLY = 2;
    private static int OP_DIVIDE = 3;
    private int current_op = -1; // current math operation selected

    private static final int BTN_W = 31;
    private static final int BTN_H = 29;
    private static final int LVL_W = 82;
    private static final int LVL_H = 30;

    private static final int OPER_Y = 104;
    private static final int PEM_Y1 = 198;
    private static final int PEM_Y2 = 233;

    private static final int DIFF_X = 595;

    // math flash cards buttons
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    // order operations buttons
    private JButton orderA;
    private JButton orderB;
    private JButton orderC;
    private JButton orderD;
    private JButton orderE;
    private JButton orderF;
    private JButton orderG;
    private JButton orderH;
    // difficulty level
    private JButton easy;
    private JButton medium;
    private JButton hard;
    // final button options
    private JButton submit;
    private JButton pass;
    // text user panes
    private JTextField userID;
    private JTextField workspace;
    private JTextField finalAnswer;
    // text
    private JTextPane questionPrompt;
    private JTextPane encouragement;
    private JButton encourageMe;

    // background image
    BufferedImage background;
    Image bgResized;
    BufferedImage correct;    //YOU GUYS MIGHT HAVE TO RESIZE
    BufferedImage incorrect;  //TODO
    private boolean showCorrect = false;
    private boolean showIncorrect = false;

    // font and size
    Font myFont = new Font( "Helvetica", Font.BOLD, 13 );

    // Math Flash Card object
    MathFlashCard flashC;
    PEMDASOrder pOrder;
    int processedAnswer = -1;
    int correctAnswer = -1;

    // prompting
    String question = "The math question will appear here...";
    String workspacePrompt = "This is your workspace, start typing...";
    String IDPrompt = "Type your ID here...";
    Encouragement goodWords = new Encouragement();

  private boolean submitPressed = false;
  private boolean letterOptionPressedLast = false;
  private boolean aOptionPressedLast = false;
  private boolean bOptionPressedLast = false;
  private boolean cOptionPressedLast = false;

	public UserInterface()
	{
	    try {
		 background = ImageIO.read(new File("media/InterfaceArt.png"));
    		 bgResized = background.getScaledInstance(700, 525, Image.SCALE_DEFAULT);
		 /* if you guys want to access the image, you need it to be either in a folder
		 * called images or you need to edit the code above
		 */
	    }
	    catch( IOException e ) {
		 System.out.println("Could not find file");
		 System.exit(-1);
	    }

	    try {
		 correct = ImageIO.read(new File("media/correct.png"));
		 /* if you guys want to access the image, you need it to be either in a folder
		 * called images or you need to edit the code above
		 */
	    }
	    catch( IOException e ) {
		 System.out.println("Could not find correct image");
		 System.exit(-1);
	    }

	    try {
		 incorrect = ImageIO.read(new File("media/incorrect.png"));
		 /* if you guys want to access the image, you need it to be either in a folder
		 * called images or you need to edit the code above
		  */
	    }
	    catch( IOException e ){
		 System.out.println("Could not find incorrect image");
		 System.exit(-1);
	    }

		this.setLayout(null);

		// math flash card buttons
		add = new JButton("");
		add.setBounds(5,OPER_Y,BTN_W,BTN_H);
		add.addActionListener(this);
		this.add(add);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);

		subtract = new JButton("");
		subtract.setBounds(41,OPER_Y,BTN_W,BTN_H);
		subtract.addActionListener(this);
		this.add(subtract);
		subtract.setOpaque(false);
		subtract.setContentAreaFilled(false);
		subtract.setBorderPainted(false);

		multiply = new JButton("");
		multiply.setBounds(77,OPER_Y,BTN_W,BTN_H);
		multiply.addActionListener(this);
		this.add(multiply);
		multiply.setOpaque(false);
		multiply.setContentAreaFilled(false);
		multiply.setBorderPainted(false);

		divide = new JButton("");
		divide.setBounds(112,OPER_Y,BTN_W,BTN_H);
		divide.addActionListener(this);
		this.add(divide);
		divide.setOpaque(false);
		divide.setContentAreaFilled(false);
		divide.setBorderPainted(false);

		// order of operations buttons
		orderA = new JButton("");
		orderA.setBounds(5,PEM_Y1,BTN_W,BTN_H);
		orderA.addActionListener(this);
		this.add(orderA);
		orderA.setOpaque(false);
		orderA.setContentAreaFilled(false);
		orderA.setBorderPainted(false);

		orderB = new JButton("");
		orderB.setBounds(41,PEM_Y1,BTN_W,BTN_H);
		orderB.addActionListener(this);
		this.add(orderB);
		orderB.setOpaque(false);
		orderB.setContentAreaFilled(false);
		orderB.setBorderPainted(false);

		orderC = new JButton("");
		orderC.setBounds(77,PEM_Y1,BTN_W,BTN_H);
		orderC.addActionListener(this);
		this.add(orderC);
		orderC.setOpaque(false);
		orderC.setContentAreaFilled(false);
		orderC.setBorderPainted(false);

		orderD = new JButton("");
		orderD.setBounds(112,PEM_Y1,BTN_W,BTN_H);
		orderD.addActionListener(this);
		this.add(orderD);
		orderD.setOpaque(false);
		orderD.setContentAreaFilled(false);
		orderD.setBorderPainted(false);

		orderE = new JButton("");
		orderE.setBounds(5,PEM_Y2,BTN_W,BTN_H);
		orderE.addActionListener(this);
		this.add(orderE);
		orderE.setOpaque(false);
		orderE.setContentAreaFilled(false);
		orderE.setBorderPainted(false);

		orderF = new JButton("");
		orderF.setBounds(41,PEM_Y2,BTN_W,BTN_H);
		orderF.addActionListener(this);
		this.add(orderF);
		orderF.setOpaque(false);
		orderF.setContentAreaFilled(false);
		orderF.setBorderPainted(false);

		orderG = new JButton("");
		orderG.setBounds(77,PEM_Y2,BTN_W,BTN_H);
		orderG.addActionListener(this);
		this.add(orderG);
		orderG.setOpaque(false);
		orderG.setContentAreaFilled(false);
		orderG.setBorderPainted(false);

		orderH = new JButton("");
		orderH.setBounds(112,PEM_Y2,BTN_W,BTN_H);
		orderH.addActionListener(this);
		this.add(orderH);
		orderH.setOpaque(false);
		orderH.setContentAreaFilled(false);
		orderH.setBorderPainted(false);

		easy = new JButton("");
		easy.setBounds(594,169,LVL_W,LVL_H);
		easy.addActionListener(this);
		this.add(easy);
		easy.setOpaque(false);
		easy.setContentAreaFilled(false);
		easy.setBorderPainted(false);

		medium = new JButton("");
		medium.setBounds(DIFF_X,201,LVL_W,LVL_H);
		medium.addActionListener(this);
		this.add(medium);
		medium.setOpaque(false);
		medium.setContentAreaFilled(false);
		medium.setBorderPainted(false);

		hard = new JButton("");
		hard.setBounds(DIFF_X,239,LVL_W,LVL_H);
		hard.addActionListener(this);
		this.add(hard);
		hard.setOpaque(false);
		hard.setContentAreaFilled(false);
		hard.setBorderPainted(false);

		submit = new JButton("");
		submit.setBounds(DIFF_X,438,LVL_W,LVL_H);
		submit.addActionListener(this);
		this.add(submit);
		submit.setOpaque(false);
		submit.setContentAreaFilled(false);
		submit.setBorderPainted(false);

		pass = new JButton("");
		pass.setBounds(DIFF_X,467,LVL_W,48);
		pass.addActionListener(this);
		this.add(pass);
		pass.setOpaque(false);
		pass.setContentAreaFilled(false);
		pass.setBorderPainted(false);

		encourageMe = new JButton("Encourage Me!");
		encourageMe.setBounds(155, 455, 404, 90);
		encourageMe.addActionListener(this);
		this.add(encourageMe);
		encourageMe.setOpaque(false);
		encourageMe.setContentAreaFilled(false);
		encourageMe.setBorderPainted(false);


	// text field entries
        userID = new JTextField(50);
        userID.setBounds(7,4,140,31);
	      userID.setText( IDPrompt );
        userID.setFont( myFont );
        userID.addActionListener(this);
        this.add(userID);

        workspace = new JTextField(50);
        workspace.setBounds(169,105,404,320);
        workspace.setText( workspacePrompt );
        workspace.setFont( myFont );
        workspace.addActionListener(this);
        this.add(workspace);

        finalAnswer = new JTextField(50);
        finalAnswer.setBounds(587,362,96,70);
        this.add(finalAnswer);

	encouragement = new JTextPane();
	encouragement.setBounds(169, 430, 404, 55);
	this.add(encouragement);
   	/*searchResultsPane = new JTextPane();
        searchResultsPane.setBounds(530,40,235,180);
        this.add(searchResultsPane);*/
       // allSongsPane.setText( getSongList() );

        this.setFocusable(true);
    }

    public Dimension getPreferredSize()
    {
        //Sets the size of the panel
        return new Dimension(700,525);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor( Color.gray );
       	g.fillRect( 0, 0, 583, 350 );
        g.drawImage( bgResized, 0, 0, null );

	// correct/incorrect images (initially invisible)
        if( showCorrect ) {
            g.drawImage( correct, 585, 270, null );
	}
	if( showIncorrect ) {
            g.drawImage( incorrect, 585, 270, null );
	}

	// font
        g.setColor( Color.BLACK );
	g.setFont( myFont );

        // this is the prompts
        g.drawString( question, 195, 35 );
    }

    public void actionPerformed(ActionEvent e)
    {
        //this is for math flash cards
        if( e.getSource() == add )
        {
        	current_op = OP_ADD;
            System.out.println("add was pressed");
        }

        else if( e.getSource() == subtract )
        {
        	current_op = OP_SUBTRACT;
        	System.out.println("subtract was pressed");
		}

		 else if( e.getSource() == multiply )
        {
        	current_op = OP_MULTIPLY;
            System.out.println("multiply was pressed");
		}

		 else if( e.getSource() == divide )
        {
        	current_op = OP_DIVIDE;
            System.out.println("divide was pressed");
		}

		// this is for order operations
    if( e.getSource() == orderA )
    {
            showCorrect = false;
            showIncorrect = false;
	    System.out.println("order A was pressed");
            letterOptionPressedLast = true;
            aOptionPressedLast = true;
    }

	else if( e.getSource() == orderB )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order B was pressed");
          letterOptionPressedLast = true;
          bOptionPressedLast = true;
        }

        else if( e.getSource() == orderC )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order C was pressed");
          letterOptionPressedLast = true;
          cOptionPressedLast = true;
        }

        else if( e.getSource() == orderD )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order D was pressed");
        }

        else if( e.getSource() == orderE )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order E was pressed");
        }

        else if( e.getSource() == orderF )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order F was pressed");
        }

        else if( e.getSource() == orderG )
        {
            showCorrect = false;
            showIncorrect = false;
          System.out.println("order G was pressed");
        }

        else if( e.getSource() == orderH )
        {
            showCorrect = false;
            showIncorrect = false;
            System.out.println("order H was pressed");
	}

    	else if( e.getSource() == encourageMe )
	{
	    String goodWord = goodWords.generateRandomEncouragement();
	    System.out.println(goodWord);
	    encouragement.setText(goodWord);
	}

        // this is for difficulty level
        if( e.getSource() == easy )
        {
          this.current_level = LVL_EASY;
          System.out.println("current level: " + current_level);
          if (letterOptionPressedLast) {
            if(aOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "a");
            } else if(bOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "b");
            } else if(cOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "c");
            } else {
              System.out.println("Invalid option.");
            }
            if (pOrder != null) {
              String[] answerAndPrompt = pOrder.promptGenerator();
              String answer = answerAndPrompt[0];
              String prompt = answerAndPrompt[1];
              question = "Please find: " + prompt;
              correctAnswer = Integer.parseInt(answer);
            }

            letterOptionPressedLast = false;
            aOptionPressedLast = false;
            bOptionPressedLast = false;
            cOptionPressedLast = false;

          } else {
            if( current_op == OP_ADD ) {
              flashC = new MathFlashCard( current_level );
              // takes in the int array of the MathFlashC
              int[] addDigits = flashC.add();
              /* stores the answer of the add function (we will use this to compare
              with our submitted answer */
              correctAnswer = addDigits[2];
              question = "Please find: " + addDigits[0] + " + " + addDigits[1];
              System.out.println( "Q: " + addDigits[0] + " + " + addDigits[1] );
            }
            else if( current_op == OP_SUBTRACT ) {
              flashC = new MathFlashCard( current_level );
              // takes in the int array of the MathFlashC
              int[] subDigits = flashC.subtract();
              /* stores the answer of the subtract function (we will use this to compare
              with our submitted answer */
              correctAnswer = subDigits[2];
              question = "Please find: " + subDigits[0] + " - " + subDigits[1];
              System.out.println( "Q: " + subDigits[0] + " - " + subDigits[1] );
            }
            else if( current_op == OP_MULTIPLY ) {
              flashC = new MathFlashCard( current_level );
              // takes in the int array of the MathFlashC
              int[] multDigits = flashC.multiply();
              /* stores the answer of the multiply function (we will use this to compare
              with our submitted answer */
              correctAnswer = multDigits[2];
              question = "Please find: " + multDigits[0] + " x " + multDigits[1];
              System.out.println( "Q: " + multDigits[0] + " x " + multDigits[1] );
            }
            else if( current_op == OP_DIVIDE ) {
              flashC = new MathFlashCard( current_level );
              // takes in the int array of the MathFlashC
              int[] divDigits = flashC.divide();
              /* stores the answer of the divide function (we will use this to compare
              with our submitted answer */
              correctAnswer = divDigits[2];
              question = "Please find: " + + divDigits[0] + "/" + divDigits[1];
              System.out.println( "Q: " + divDigits[0] + " / " + divDigits[1] );
            }
          }
        }

        else if( e.getSource() == medium )
        {
          this.current_level = LVL_MEDIUM;
          System.out.println("current level: " + current_level);
          if (letterOptionPressedLast) {
            if(aOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "a");
            } else if(bOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "b");
            } else if(cOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "c");
            } else {
              System.out.println("Invalid option.");
            }
            if (pOrder != null) {
              String[] answerAndPrompt = pOrder.promptGenerator();
              String answer = answerAndPrompt[0];
              String prompt = answerAndPrompt[1];
              question = "Please find: " + prompt;
              correctAnswer = Integer.parseInt(answer);
            }

            letterOptionPressedLast = false;
            aOptionPressedLast = false;
            bOptionPressedLast = false;
            cOptionPressedLast = false;

          } else {
		  if( current_op == OP_ADD ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] addDigits = flashC.add();
            /* stores the answer of the add function (we will use this to compare
            with our submitted answer */
            correctAnswer = addDigits[2];
            question = "Please find: " + addDigits[0] + " + " + addDigits[1];
            System.out.println( "Q: " + addDigits[0] + " + " + addDigits[1] );
          }
		  else if( current_op == OP_SUBTRACT ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] subDigits = flashC.subtract();
            /* stores the answer of the subtract function (we will use this to compare
            with our submitted answer */
            correctAnswer = subDigits[2];
            question = "Please find: " + subDigits[0] + " - " + subDigits[1];
            System.out.println( "Q: " + subDigits[0] + " - " + subDigits[1] );
          }
          else if( current_op == OP_MULTIPLY ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] multDigits = flashC.multiply();
            /* stores the answer of the multiply function (we will use this to compare
            with our submitted answer */
            correctAnswer = multDigits[2];
            question = "Please find: " + multDigits[0] + " x " + multDigits[1];
            System.out.println( "Q: " + multDigits[0] + " x " + multDigits[1] );
          }
          else if( current_op == OP_DIVIDE ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] divDigits = flashC.divide();
            /* stores the answer of the divide function (we will use this to compare
            with our submitted answer */
            correctAnswer = divDigits[2];
            question = "Please find: " + divDigits[0] + " / " + divDigits[1];
            System.out.println( "Q: " + divDigits[0] + " / " + divDigits[1] );
          }        }

        }

        else if( e.getSource() == hard )
        {
          this.current_level = LVL_HARD;
          System.out.println("current level: " + current_level);
          if (letterOptionPressedLast) {
            if(aOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "a");
            } else if(bOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "b");
            } else if(cOptionPressedLast) {
              pOrder = new PEMDASOrder(this.current_level, "c");
            } else {
              System.out.println("Invalid option.");
            }
            if (pOrder != null) {
              String[] answerAndPrompt = pOrder.promptGenerator();
              String answer = answerAndPrompt[0];
              String prompt = answerAndPrompt[1];
              question = "Please find: " + prompt;
              correctAnswer = Integer.parseInt(answer);
            }

            letterOptionPressedLast = false;
            aOptionPressedLast = false;
            bOptionPressedLast = false;
            cOptionPressedLast = false;

          } else {

		  if( current_op == OP_ADD ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] addDigits = flashC.add();
            /* stores the answer of the add function (we will use this to compare
            with our submitted answer */
            correctAnswer = addDigits[2];
            question = "Please find: " + addDigits[0] + " + " + addDigits[1];
            System.out.println( "Q: " + addDigits[0] + " + " + addDigits[1] );
          }
          else if( current_op == OP_SUBTRACT ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] subDigits = flashC.subtract();
            /* stores the answer of the subtract function (we will use this to compare
            with our submitted answer */
            correctAnswer = subDigits[2];
            question = "Please find: " + subDigits[0] + " - " + subDigits[1];
            System.out.println( "Q: " + subDigits[0] + " - " + subDigits[1] );
          }
          else if( current_op == OP_MULTIPLY ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] multDigits = flashC.multiply();
            /* stores the answer of the multiply function (we will use this to compare
            with our submitted answer */
            correctAnswer = multDigits[2];
            question = "Please find: " + multDigits[0] + " x " + multDigits[1];
            System.out.println( "Q: " + multDigits[0] + " x " + multDigits[1] );
          }
          else if( current_op == OP_DIVIDE ) {
            flashC = new MathFlashCard( current_level );
            // takes in the int array of the MathFlashC
            int[] divDigits = flashC.divide();
            /* stores the answer of the divide function (we will use this to compare
            with our submitted answer */
            correctAnswer = divDigits[2];
            question = "Please find: " + divDigits[0] + " / " + divDigits[1];
            System.out.println( "Q: " + divDigits[0] + " / " + divDigits[1] );
          }
        }
      }
        else if( e.getSource() == submit )
        {
             this.submitPressed = true;
             //user submits a final answer and we must parse it
	     String answer = finalAnswer.getText();
	     // in case someone submits an empty text
	     try {
	     	processedAnswer = Integer.parseInt(answer);
	     } catch(Exception ex) {
	     	System.err.println("Error in parsing");
		processedAnswer = -1000000000;
	     }
	    //if final answer is correct, display
	    if( processedAnswer == correctAnswer ) {
	        showCorrect = true;
                showIncorrect = false;
	    } else {
	        showCorrect = false;
	        showIncorrect = true;
	    }
            System.out.println("submit was pressed, answer: " + answer + ", correct: " + correctAnswer);
        }

        else if( e.getSource() == pass )
        {
          System.out.println("pass was pressed");
        }

	// this is for actions in the prompts (ID, workspace..)
	if( e.getSource() == userID ) {
	  // user is commenting in workspace, prompt goes away
	  //TODO
	  userID.setText( "" );
	}

	else if( e.getSource() == workspace ) {
	  // user is commenting in workspace, prompt goes away
	  //TODO
	  workspace.setText( "" );
	}



        repaint();
    }
}
