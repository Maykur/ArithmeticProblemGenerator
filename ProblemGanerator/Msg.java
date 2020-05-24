import javax.swing.JOptionPane;

public class Msg {
	
	/*
	 Method that takes in a string input from the user
	 */
	public static String in(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	
	/*
	 Method that shows a JOptionPane text box with a message parameter passed in
	 */
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
