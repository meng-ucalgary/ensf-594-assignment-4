/**
 * Custom exception to throw when item is accessed or popped from an empty stack
 *
 * @author Bhavyai Gupta
 */
public class StackUnderflowError extends Exception {
    public StackUnderflowError(String errorMessage) {
        super(errorMessage);
    }
}
