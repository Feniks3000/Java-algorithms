package lesson3;

public class DoublyLinkedList {
    private Node root;
    private Node termination;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getTermination() {
        return termination;
    }

    public void setTermination(Node termination) {
        this.termination = termination;
    }

    public void addToEnd(int value) {
        Node newNode = new Node();
        newNode.setElement(value);
        if (termination == null) {
            root = newNode;
        } else {
            termination.setNext(newNode);
            newNode.setPrevious(termination);
        }
        termination = newNode;
    }

    public void remove(int position) {
        if (root != null) {
            int currentPosition = 0;
            Node node = root;
            while (node.getNext() != null) {
                if (currentPosition == position) {
                    break;
                }
                node = node.getNext();
                currentPosition++;
            }
            if (currentPosition == position) {
                if (node.equals(root)) {
                    root = node.getNext();
                    root.setPrevious(null);
                } else if (node.equals(termination)) {
                    termination = node.getPrevious();
                    termination.setNext(null);
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
            }
        }
    }

    public void add(int position, int value) {
        if (root != null) {
            int currentPosition = 0;
            Node node = root;
            while (node != null) {
                if (currentPosition == position) {
                    break;
                }
                node = node.getNext();
                currentPosition++;
            }
            Node newNode = new Node();
            newNode.setElement(value);
            if (currentPosition == position) {
                if (node.equals(root)) {
                    root.setPrevious(newNode);
                    newNode.setNext(root);
                    root = newNode;
                } else if (node.equals(termination)) {
                    termination.getPrevious().setNext(newNode);
                    newNode.setPrevious(termination.getPrevious());
                    termination.setPrevious(newNode);
                    newNode.setNext(termination);
                } else {
                    newNode.setPrevious(node.getPrevious());
                    node.setPrevious(newNode);
                    newNode.setNext(node);
                }
            }
        } else {
            addToEnd(value);
        }
    }

    public Node get(int position) {
        if (root != null) {
            int currentPosition = 0;
            Node node = root;
            while (node.getNext() != null) {
                if (currentPosition == position) {
                    break;
                }
                node = node.getNext();
                currentPosition++;
            }
            if (currentPosition == position) {
                return node;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void print(int position) {
        Node node = get(position);
        if (node != null) {
            System.out.print(node.getElement());
            if (node.getPrevious() != null) {
                System.out.println("\tPrevious value - " + node.getPrevious().getElement());
            }
            if (node.getNext() != null) {
                System.out.println("\tNext value - " + node.getNext().getElement());
            }
            if (node.getPrevious() == null && node.getNext() == null) {
                System.out.println();
            }
        }
    }

    public void printList() {
        Node node = root;
        while (node != null) {
            System.out.println(node.toString());
            node = node.getNext();
        }
    }

    public void sortPrintList() {
        Node node = root;
        while (node != null) {
            System.out.print(node.getElement() + ", ");
            node = node.getNext();
        }
    }
}
