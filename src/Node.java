/**
 * Represents a Node of a Stack
 *
 * @author Bhavyai Gupta
 */
public class Node {
    public Object data;
    public Node next;

    /**
     * Creates a new node with object <code>o</code>
     *
     * @param o object to be stored in the Node
     */
    public Node(Object o) {
        this.data = o;
        this.next = null;
    }
}
