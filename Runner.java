import javax.swing.JFrame;
public class Runner
{
    public static void main(String args[])
    {
        UserInterface anya = new UserInterface();
        JFrame frame = new JFrame("anya");
         
        frame.add(anya);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
