/**
 * Represents a Node of a Stack
 *
 * @author Bhavyai Gupta
 */
public class Node {
    public char data;
    public Node next;

    /**
     * Creates a new node with char <code>c</code>
     *
     * @param c char to be stored in the Node
     */
    public Node(char c) {
        this.data = c;
        this.next = null;
    }
}
