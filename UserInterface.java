/*
 * Name: Nicole Trappe
 * Hackathon, Spring '18
 * Date: 7 April 2018
 */

import java.awt.Graphics;
import java.awt.Color;
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
    private int current_level = -1;
    
    private static int OP_ADD = 0;
    private static int OP_SUBTRACT = 1;
    private static int OP_MULTIPLY = 2;
    private static int OP_DIVIDE = 3;
    private int current_op = -1;

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
    private JTextPane help;
    private JTextPane encouragement;
    
    
    // background image
    BufferedImage background;
    
    MathFlashCard flashC;
    int processedAnswer = -1;
    int correctAnswer = -1;
    String question = "";

	
	public UserInterface()
	{		
		try
		{
			background = ImageIO.read(new File("images/InterfaceArt.png"));
			/* if you guys want to access the image, you need it to be either in a folder
			 * called images or you need to edit the code above
			 */
		}
		catch( IOException e ){
			System.out.println("Could not find file");
			System.exit(-1);
		}
		
		this.setLayout(null);
		
		// math flash card buttons 
		add = new JButton(""); 
		add.setBounds(9,179,54,50);
		add.addActionListener(this);
		this.add(add);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
	
		subtract = new JButton(""); 
		subtract.setBounds(70,179,54,50);
		subtract.addActionListener(this);
		this.add(subtract);
		subtract.setOpaque(false);
		subtract.setContentAreaFilled(false);
		subtract.setBorderPainted(false);
		
		multiply = new JButton(""); 
		multiply.setBounds(132,179,54,50);
		multiply.addActionListener(this);
		this.add(multiply);
		multiply.setOpaque(false);
		multiply.setContentAreaFilled(false);
		multiply.setBorderPainted(false);
		
		divide = new JButton(""); 
		divide.setBounds(192,179,54,50);
		divide.addActionListener(this);
		this.add(divide);
		divide.setOpaque(false);
		divide.setContentAreaFilled(false);
		divide.setBorderPainted(false);
		
		// order of operations buttons 
		orderA = new JButton(""); 
		orderA.setBounds(9,340,54,52);
		orderA.addActionListener(this);
		this.add(orderA);
		orderA.setOpaque(false);
		orderA.setContentAreaFilled(false);
		orderA.setBorderPainted(false);
		
		orderB = new JButton(""); 
		orderB.setBounds(70,340,54,52);
		orderB.addActionListener(this);
		this.add(orderB);
		orderB.setOpaque(false);
		orderB.setContentAreaFilled(false);
		orderB.setBorderPainted(false);
		
		orderC = new JButton("");
		orderC.setBounds(132,340,54,52);
		orderC.addActionListener(this);
		this.add(orderC);
		orderC.setOpaque(false);
		orderC.setContentAreaFilled(false);
		orderC.setBorderPainted(false);
		
		orderD = new JButton(""); 
		orderD.setBounds(192,340,54,52);
		orderD.addActionListener(this);
		this.add(orderD);
		orderD.setOpaque(false);
		orderD.setContentAreaFilled(false);
		orderD.setBorderPainted(false);
		
		orderE = new JButton("");
		orderE.setBounds(9,400,54,52);
		orderE.addActionListener(this);
		this.add(orderE);
		orderE.setOpaque(false);
		orderE.setContentAreaFilled(false);
		orderE.setBorderPainted(false);
		
		orderF = new JButton(""); 
		orderF.setBounds(70,400,54,52);
		orderF.addActionListener(this);
		this.add(orderF);
		orderF.setOpaque(false);
		orderF.setContentAreaFilled(false);
		orderF.setBorderPainted(false);
		
		orderG = new JButton(""); 
		orderG.setBounds(132,400,54,52);
		orderG.addActionListener(this);
		this.add(orderG);
		orderG.setOpaque(false);
		orderG.setContentAreaFilled(false);
		orderG.setBorderPainted(false);
		
		orderG = new JButton(""); 
		orderG.setBounds(192,20,94,52);
		orderG.addActionListener(this);
		this.add(orderG);
		orderG.setOpaque(false);
		orderG.setContentAreaFilled(false);
		orderG.setBorderPainted(false);
		
		easy = new JButton(""); 
		easy.setBounds(1018,290,140,52);
		easy.addActionListener(this);
		this.add(easy);
		easy.setOpaque(false);
		easy.setContentAreaFilled(false);
		easy.setBorderPainted(false);
				
		medium = new JButton(""); 
		medium.setBounds(1020,345,140,52);
		medium.addActionListener(this);
		this.add(medium);
		medium.setOpaque(false);
		medium.setContentAreaFilled(false);
		medium.setBorderPainted(false);
		
		hard = new JButton(""); 
		hard.setBounds(1020,410,140,52);
		hard.addActionListener(this);
		this.add(hard);
		hard.setOpaque(false);
		hard.setContentAreaFilled(false);
		hard.setBorderPainted(false);
		
		submit = new JButton(""); 
		submit.setBounds(1020,750,140,52);
		submit.addActionListener(this);
		this.add(submit);
		submit.setOpaque(false);
		submit.setContentAreaFilled(false);
		submit.setBorderPainted(false);
		
		pass = new JButton(""); 
		pass.setBounds(1020,800,140,82);
		pass.addActionListener(this);
		this.add(pass);
		pass.setOpaque(false);
		pass.setContentAreaFilled(false);
		pass.setBorderPainted(false);
		        
		// text field entries
        userID = new JTextField(50);
        userID.setBounds(11,10,240,49);
        this.add(userID);
        
        workspace = new JTextField(50);
        workspace.setBounds(290,180,692,548);
        this.add(workspace);
        
        finalAnswer = new JTextField(50);
        finalAnswer.setBounds(1007,620,165,120);
        this.add(finalAnswer);
 
   		/*searchResultsPane = new JTextPane();
        searchResultsPane.setBounds(530,40,235,180);
        this.add(searchResultsPane);*/        
       // allSongsPane.setText( getSongList() );

      
        this.setFocusable(true); 
    }
    
    public Dimension getPreferredSize()
    {
        //Sets the size of the panel
        return new Dimension(1200,900);
    }
  
    public void paintComponent(Graphics g)
    {       
        super.paintComponent(g); 
        
        g.setColor( Color.gray );
       	g.fillRect( 0, 0, 1000, 600 ); 
        g.drawImage( background, 0, 0, null );
        g.setColor( Color.black ); 
        // this is the question prompt
        g.drawString( question, 350, 60 );  
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
            System.out.println("order A was pressed");
		}	
		
		else if( e.getSource() == orderB )
        {
          System.out.println("order B was pressed");
        }
        
        else if( e.getSource() == orderC )
        {
          System.out.println("order C was pressed");
        }
        
        else if( e.getSource() == orderD )
        {
          System.out.println("order D was pressed");
        }
        
        else if( e.getSource() == orderE )
        {
          System.out.println("order E was pressed");
        }
        
        else if( e.getSource() == orderF )
        {
          System.out.println("order F was pressed");
        }
        
        else if( e.getSource() == orderG )
        {
          System.out.println("order G was pressed");
        }
        
        // this is for difficulty level
        if( e.getSource() == orderH )
        {
          System.out.println("order H was pressed");
        }
        
        else if( e.getSource() == easy )
        {
          current_level = LVL_EASY;
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
            System.out.println( "Q: " + divDigits[0] + " / " + divDigits[1] );
          }
        }
        
        else if( e.getSource() == medium )
        {
          current_level = LVL_MEDIUM;
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
        
        else if( e.getSource() == hard )
        {
          current_level = LVL_MEDIUM;
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
        
        else if( e.getSource() == submit )
        {
          //user submits a final answer and we must parse it
		  String answer = finalAnswer.getText();
		  processedAnswer = Integer.parseInt( answer );
		  //if final answer is correct, display 
		  
          System.out.println("submit was pressed, answer: " + answer + ", correct: " + correctAnswer);
        }
        
        else if( e.getSource() == pass )
        {
          System.out.println("pass was pressed");
        }

        	
        
        repaint();
    }
}
