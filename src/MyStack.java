/**
 * A stack
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
     * @param o the Object to be pushed
     */
    public void push(Object o) {
        Node temp = new Node(o);
        temp.next = this.top;
        this.top = temp;
    }

    /**
     * Pops an item from the top of the stack
     *
     * @return the Object popped
     * @throws StackUnderflowError if the stack is empty
     */
    public Object pop() throws StackUnderflowError {
        if (this.isEmpty()) {
            throw new StackUnderflowError("The stack is empty");
        }

        else {
            Object t = this.top.data;
            this.top = this.top.next;
            return t;
        }
    }

    /**
     * Returns the topmost item on the stack
     *
     * @return the topmost Object
     * @throws StackUnderflowError if the stack is empty
     */
    public Object peek() throws StackUnderflowError {
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
