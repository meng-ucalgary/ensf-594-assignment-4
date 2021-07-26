import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements the logic to solve the given problem statement in question 3
 *
 * @author Bhavyai Gupta
 */
class Q3 {
    /**
     * Evaluates the postfix expression
     *
     * @param input infix expression
     * @return postfix expression
     */
    public double evaluatePostfix(String input) {
        MyStack stack = new MyStack();
        double result = 0.0;

        int index = 0;

        // loop through every character of the string
        while (index < input.length()) {
            char currChar = input.charAt(index);

            if (String.valueOf(currChar).matches("[0-9]")) {
                stack.push(Double.parseDouble(String.valueOf(currChar)));
            }

            // processing operators
            else if (currChar == '*' || currChar == '/' || currChar == '+' || currChar == '-') {
                try {
                    double a = (double) stack.pop();
                    double b = (double) stack.pop();

                    System.out.println(a);
                    System.out.println(b);

                    switch (currChar) {
                        case '*':
                            stack.push((double) (a * b));
                            break;
                        case '/':
                            stack.push((double) (a / b));
                            break;
                        case '+':
                            stack.push((double) (a + b));
                            break;
                        case '-':
                            stack.push((double) (a - b));
                            break;
                    }
                }

                // empty stack means postfix expression is incorrect
                catch (StackUnderflowError e) {
                    System.err.printf("%nIncorrect postfix expression%n");
                    Runtime.getRuntime().exit(1);
                }
            }

            index++;
        }

        try {
            result = (double) stack.pop();
        }

        // empty stack means postfix expression is incorrect
        catch (StackUnderflowError e) {
            System.err.printf("%nIncorrect postfix expression%n");
            Runtime.getRuntime().exit(1);
        }

        return result;
    }

    /**
     * Receive input string from user
     *
     * @return String entered by the user
     */
    public String getInput() {
        String temp = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            temp = br.readLine();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    /**
     * Evaluate the postfix expression and print the result to stdout
     */
    private void main() {
        System.out.printf("%nEnter the postfix expression you want to evaluate: ");
        String input = this.getInput();

        System.out.printf("%nResult: %.2f%n", this.evaluatePostfix(input));
    }

    /**
     * Entry point of the program
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Q3 app = new Q3();
        app.main();
    }
}
