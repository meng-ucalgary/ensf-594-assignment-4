import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements the logic to solve the given problem statement in question 1
 *
 * @author Bhavyai Gupta
 */
class Q1 {
    /**
     * Check if the parameter input has balanced parenthesis
     *
     * @param input string containing parenthesis
     * @return <code>true</code> if parenthesis are balanced, <code>false</code>
     *         otherwise
     */
    public boolean checkParenthesis(String input) {
        MyStack p = new MyStack();

        int index = 0;

        // loop through every character of the string
        while (index < input.length()) {
            char currChar = input.charAt(index);

            switch (currChar) {
                case '(':
                case '{':
                case '[':
                    // push all the opening parenthesis
                    p.push(currChar);
                    break;

                case ')': {
                    try {
                        // last opened brace must match
                        if (p.peek() == '(') {
                            p.pop();
                        }

                        else {
                            return false;
                        }
                    }

                    // if stack is empty during entering of closing braces, its invalid
                    catch (StackUnderflowError e) {
                        return false;
                    }
                }
                    break;

                case '}': {
                    try {
                        // last opened brace must match
                        if (p.peek() == '{') {
                            p.pop();
                        }

                        else {
                            return false;
                        }
                    }

                    // if stack is empty during entering of closing braces, its invalid
                    catch (StackUnderflowError e) {
                        return false;
                    }
                }
                    break;

                case ']': {
                    try {
                        // last opened brace must match
                        if (p.peek() == '[') {
                            p.pop();
                        }

                        else {
                            return false;
                        }
                    }

                    // if stack is empty during entering of closing braces, its invalid
                    catch (StackUnderflowError e) {
                        return false;
                    }
                }
                    break;
            }

            index++;
        }

        // at the end, stack must be empty for the parenthesis to be balanced
        if (p.isEmpty()) {
            return true;
        }

        else {
            return false;
        }
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
     * Read the parenthesis and print if they are balanced
     */
    private void main() {
        System.out.printf("%nEnter set of parenthesis: ");
        String input = this.getInput();

        if (this.checkParenthesis(input) == true) {
            System.out.printf("%nEntered set of parenthesis is valid.%n");
        }

        else {
            System.out.printf("%nEntered set of parenthesis is invalid.%n");
        }
    }

    /**
     * Entry point of the program
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Q1 app = new Q1();
        app.main();
    }
}
