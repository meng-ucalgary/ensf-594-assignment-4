import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements the logic to solve the given problem statement in question 2
 *
 * @author Bhavyai Gupta
 */
class Q2 {
    /**
     * Converts infix expression to postfix expression
     *
     * @param input infix expression
     * @return postfix expression
     */
    private String infixToPostfix(String input) {
        StringBuilder sb = new StringBuilder();
        MyStack operators = new MyStack();

        int index = 0;

        // loop through every character of the string
        while (index < input.length()) {
            char currChar = input.charAt(index);

            // output letters and digits as it is
            if (String.valueOf(currChar).matches("[a-zA-Z0-9]")) {
                sb.append(currChar);
                sb.append(" ");
            }

            // processing operators
            else if (currChar == '*' || currChar == '/' || currChar == '+' || currChar == '-') {
                try {
                    // higher operators gets pushed to stack
                    if (this.precedence(currChar) > this.precedence((Character) operators.peek())) {
                        operators.push(Character.valueOf(currChar));
                    }

                    // lower operator pops all higher and equal operators, but themselves go (pushed) to stack
                    else {
                        while (this.precedence(currChar) <= this.precedence((Character) operators.peek())) {
                            sb.append(operators.pop());
                            sb.append(" ");
                        }

                        operators.push(Character.valueOf(currChar));
                    }
                }

                // empty stack always accept
                catch (StackUnderflowError e) {
                    operators.push(Character.valueOf(currChar));
                }
            }

            index++;
        }

        // output the remaining operators
        while (true) {
            try {
                sb.append(operators.pop());
                sb.append(" ");
            }

            catch (StackUnderflowError e) {
                break;
            }
        }

        return sb.toString();
    }

    /**
     * Returns precedence of arithmetic operators as an integer
     *
     * @param c an arithmetic operator
     * @return an integer denoting relative precedence. Higher integer, higher
     *         precedence
     */
    public int precedence(char c) {
        int p = 0;

        switch (c) {
            case '+':
                p = 1;
                break;

            case '-':
                p = 1;
                break;

            case '*':
                p = 2;
                break;

            case '/':
                p = 2;
                break;
        }

        return p;
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
     * Read the infix expression and print the postfix expression
     */
    private void main() {
        System.out.printf("%nEnter the infix expression: ");
        String input = this.getInput();

        System.out.printf("%nEquivalent postfix expression: %s%n", this.infixToPostfix(input));
    }

    /**
     * Entry point of the program
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Q2 app = new Q2();
        app.main();
    }
}
