package HardMath;

import javax.swing.JOptionPane;

public class Window {

	/*
	 * This method displays a msg on a JOptionPane, displaying the parameter as the msg
	 */
	public void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/*
	 * This method displays a msg on a JOptionPane, but takes in a user's input
	 * and returns it as a String
	 */
	public String in(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	/*
	 * This methods displays a JOptionPane box with a string array of options which
	 * act as a way of making the user make choices without freedom
	 * of typing whatever
	 */
	public int option(String[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
}