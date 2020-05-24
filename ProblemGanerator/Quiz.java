import java.util.Random;

import LAB1.mod.Position;

import static java.lang.Integer.parseInt;

public class Quiz{
	//INSTANCE VARIBLES
    static Random rand = new Random();
    static Window w = new Window();
    static boolean continuePlaying = true;
    static int cnt = 1;
    static int correct = 0;
    private static final String[] Replay = { "Codes", "Math"};
    private static final String[] rewind = { "Heck yeah", "Nah"};

    /*
     * MAIN METHOD (Runs the game - starts by setting a boolean true that'll only turn false once the player
     * decides to stop playing. This method opens with a JOptionPane window asking the user if they want to see codes
     * to access credits/hard mode or continue in standard, which is this class. The game plays by opening JOptionPane windows
     * that display a math problem that must be solved, and ends based on how many problems the user wants to answer or they
     * type exit. Once finished will all their questions, they are shown a percent based on their answers (# right/ # total).
     */
    public static void main(String[] args) {
        boolean re = true;
        while (re) {
               int check = 0;
               int loop = -1;
               int correct = 0;
                boolean test = false;
                cnt = 1;
                	int a =w.option(Replay, "Would you like to see the special codes or go straight into the math game?");
                	if(a == 0) {
                	w.msg("List of special codes you can input ONLY on the main screen:\nHard or hard for a much bigger challenge\nCredits for the Credits");
                	}
                	while(loop == -1) {
                    String b = Msg.in("(Main Screen)\nHow many questions would you like to answer?\nOnly use codes or numbers please");
                    if (b.contentEquals("exit")) {
                        System.exit(0);
                    }
                    if (b.contentEquals("Exit")) {
                        System.exit(0);
                    }
                    if (b.contentEquals("hard")) {
                    	w.msg("Secret Game Activated!");
                        HardMath.Quiz.runThis();
                        break;
                    }
                    if (b.contentEquals("Hard")) {
                    	w.msg("Secret Game Activated!");
                    	 HardMath.Quiz.runThis();
                        break;
                    }
                    if (b.contentEquals("Credits")) {
                    w.msg("Secret Screen Activated!");
                    w.msg("Credits: Julian Garcia");
                    }
                         loop = Integer.parseInt(CheckStr(b));
                	}
                        while (cnt <= loop) {
                        check = 0;
                            int n1 = rand.nextInt(10);
                            int n2 = rand.nextInt(10);
                            char operator = genOperator(rand.nextInt(3));
                            int answer = -1;
                            while(answer == -1) {
                            String x = Msg.in(evaluateQuestion(n1, n2, operator, cnt, loop));
                            if (x.contentEquals("exit")) {
                                System.exit(0);
                            }
                            if (x.contentEquals("Exit")) {
                                System.exit(0);
                            }
                             answer =  Integer.parseInt(CheckStr(x));
                            }
                                if (answer == calcAnswer(n1, n2, operator)) {
                                	String[] hi = {"Correct!", "Awesome!", "Wonderful!", "Nice!"};
                                	String _hi = hi[(int)(Math.random()*4)];
                                    w.msg(_hi);
                                    cnt++;
                                    correct++;
                                    if (cnt > loop) {
                                        break;
                                    }

                                } else if (answer != calcAnswer(n1, n2, operator)) {
                                	String[] hi2 = {"Wrong!", "How could you get that wrong?!", "You can do better!", "Come on!"};
                                	String _hi2 = hi2[(int)(Math.random()*4)];
                                    w.msg(_hi2 +" The correct answer was "+calcAnswer(n1, n2, operator));
                                    cnt++;

                                    if (cnt > loop) {
                                        break;
                                    }

                                }

                        }
                        endScore(correct, loop);
                       int f = w.option(rewind, "Would you like to play again?");
                       if(f == 1) {
                    	   re = false;
                    	w.msg("Hope you enjoyed doing some math!");
                        System.exit(0);
                        break;
                       } 
                    }
    		}

    /*
     * This method generates the operator that'll be used randomly (either + or -)
     */
    public static char genOperator(int a){
        switch(a){
            case 0: return '+';
            default : return '-';
        }
    }
    
    /*
     * This method evaluates the problem, passing in n1 (number one in the problem) and n2 (number 2),
     * and then uses the other two parameters cnt and lo to show what question they are on and how many they chose for their total. The char operator parameter
     * passes in the operator being used. This method returns the string that presents the randomly chosen operator and number in the JOptionPane window.
     */
    public static String evaluateQuestion(int n1, int n2, char operator, int cnt, int lo){
        if(n1 - n2 < 0) {
            int n3 = n1;
            n1 = n2;
            n2 = n3;
            return "Question #" +cnt +" out of " +lo + "\nThe problem is: " + n1 + " " + operator + " " + n2;
        }
        else {
        	return "Question #" +cnt +" out of " +lo + "\nThe problem is: " + n1 + " " + operator + " " + n2;
        }
    }

    /*
     * This method calculates the answer, using the same n1 n2 and operator parameters from the evaluateQuestion method.
     * It checks if n1 - n2 is going to be negative to then flip them to always guarantee a positive answer.
     */
    public static int calcAnswer(int n1, int n2, char operator){
        if(n1 - n2 < 0) {
            int n3 = n1;
            n1 = n2;
            n2 = n3;
        }

        switch (operator){
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            default: return -1;
        }
    }
    
    /*
     * This method is what checks the answer put in by the person, it parses their answer to an int and depending on their answer
     * like if they type exit to end the program, it'll exit. If the person types something that isn't a number, it'll return -1,
     * which is what causes them to re-answer the question. If the person types any number, it'll return it and is then checked in the main method whether or not it's correct.
     */
    public static String CheckStr(String input)
    {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            if(input.equals("exit") || input.equals("Exit") || input.equals("EXIT"))
            {
            	System.exit(0);
            }
            return "-1";
        }

        return input;
    }

    /*
     * This method displays the end score at the end of the game by turning the amount you got right (a) and the total amount (b) 
     * and divides them together and then multiplies by 100.
     */
    public static void endScore(int a, int b) {
        w.msg("You got " +(double)a / (double)b * 100 + "% correct!");
    }
}
