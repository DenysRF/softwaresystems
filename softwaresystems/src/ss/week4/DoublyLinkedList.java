package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
        // TODO: implement, see exercise P-4.17
    	if (element != null) {
    		Node newNode = new Node(element);
    		if (index == 0 && size == 0) {
    			Node last = head.previous;
    			newNode.previous = last;
    			newNode.next = head;
    			head.previous = newNode;
    			last.next = newNode;
    	} else {
    		Node p = getNode(index - 1);
    		newNode.next = p.next;
    		newNode.previous = p;
    		p.next = newNode;
    		newNode.next.previous = newNode;
    		}
    	size += 1;
    	}
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        // TODO: implement, see exercise P-4.17
    	if (index == 0) {
    		head = head.next;
    		head.next.previous = head.next;
    	} else {
    		Node x = getNode(index - 1);
    		x.next = x.next.next;
    		x.next.previous = x;
    	}
    	size -= 1;
    	
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
