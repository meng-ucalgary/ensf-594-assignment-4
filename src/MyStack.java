/**
 * A char stack
 *
 * @author Bhavyai Gupta
 */
public class MyStack {
    private Node top;

    /**
     * Creates an empty stack
     */
    public MyStack() {
        this.top = null;
    }

    /**
     * Pushes the item at the top of the stack
     *
     * @param c the char to be pushed
     */
    public void push(char c) {
        Node temp = new Node(c);
        temp.next = this.top;
        this.top = temp;
    }

    /**
     * Pops an item from the top of the stack
     *
     * @return the char popped
     * @throws StackUnderflowError if the stack is empty
     */
    public char pop() throws StackUnderflowError {
        if (this.isEmpty()) {
            throw new StackUnderflowError("The stack is empty");
        }

        else {
            char t = this.top.data;
            this.top = this.top.next;
            return t;
        }
    }

    /**
     * Returns the topmost item on the stack
     *
     * @return the topmost char
     * @throws StackUnderflowError if the stack is empty
     */
    public char peek() throws StackUnderflowError {
        if (this.isEmpty()) {
            throw new StackUnderflowError("The stack is empty");
        }

        else {
            return this.top.data;
        }
    }

    /**
     * Checks if the stack if empty
     *
     * @return <code>true</code> if the stack is empty, <code>false</code> otherwise
     */
    public boolean isEmpty() {
        return (this.top == null);
    }
}
