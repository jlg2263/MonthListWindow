import javax.swing.*;		// Needed for swing classes
import java.awt.event.*;	// Needed for action-listener interface

/**
 * The KiloConverter class displays a JFrame that lets
 * the user enter a distance in kilometers. When the 
 * Calculate button is clicked, a dialog box is displayed
 * with the distance converted to miles.
 */

public class KiloConverter extends JFrame
{
	private JPanel panel;					// To reference a panel
	private JLabel messageLabel;			// To reference a label
	private JTextField kiloTextField;		// To reference text
	private JButton calcButton;				// To reference a button
	private final int WINDOW_WIDTH = 310;	// Window width
	private final int WINDOW_HEIGHT = 100;	// Window height
	
	/**
	 * Constructor
	 */
	
	public KiloConverter()
	{
		// Set the window title
		setTitle("Kilometer Converter");
		
		// Set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify what happens when close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build the panel and add it to the frame
		buildPanel();
		add(panel);
		
		// Display the window
		setVisible(true);
	}
	
	/**
	 * The buildPanel method adds a label, text field, 
	 * and button to a panel.
	 */
	private void buildPanel()
	{
		// Create a label, text field, and button
		messageLabel = new JLabel("Enter a distance in Kilometers");
		kiloTextField = new JTextField(10);
		calcButton = new JButton("Calculate");
		
		// Add a action listener to the button
		calcButton.addActionListener(new CalcButtonListener());
		
		// Create a JPanel object and let the panel field reference it
		panel = new JPanel();
		
		// Add the button, text field and label to the panel
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);
	}
	
	/**
	 * CalcButtonListener is an action listener class for the 
	 * calculate button
	 */
	
	private class CalcButtonListener implements ActionListener
	{
		/**
		 * The actionPerformed method executes when the user
		 * clicks the button
		 * @param e The event object
		 */
		
		public void actionPerformed(ActionEvent e)
		{
			// Declare local variables
			final double CONVERSION = 0.6214;
			String input;						// To hold user input
			double miles;						// To hold # of miles
			
			// Get the text from user input/text field
			input = kiloTextField.getText();
			
			// Convert user input into miles
			miles = Double.parseDouble(input) * CONVERSION;
			
			// Display the result
			JOptionPane.showMessageDialog(null, input + " kilometers is " +
											miles + " miles.");
		}
	}
	
	/**
	 * Main method
	 */
	
	public static void main(String[] args)
	{
		new KiloConverter();
		
	}
}
