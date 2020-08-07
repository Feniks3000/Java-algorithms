package lesson3;

public class Node implements Iterator {
    private Integer element;
    private Node next;
    private Node previous;

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer e) {
        element = e;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        next = n;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + ((next != null) ? next.getElement() : "null") +
                ", previous=" + ((previous != null) ? previous.getElement() : "null") +
                '}';
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public Node next() {
        return next;
    }

    @Override
    public Node previous() {
        return previous;
    }
}