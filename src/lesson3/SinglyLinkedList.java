package lesson3;

public class SinglyLinkedList {
    private Node root;

    public void addToEnd(int value) {
        if (root != null) {
            Node node = root;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            Node newNode = new Node();
            newNode.setElement(value);
            node.setNext(newNode);
        } else {
            root = new Node();
            root.setElement(value);
        }
    }

    public void remove(int position) {
        if (root != null) {
            int currentPosition = 0;
            Node prevNode = null;
            Node node = root;
            while (node.getNext() != null) {
                if (currentPosition == position) {
                    break;
                }
                prevNode = node;
                node = node.getNext();
                currentPosition++;
            }
            if (currentPosition == position) {
                if (prevNode != null) {
                    prevNode.setNext(node.getNext());
                } else {
                    root = node.getNext();
                }
            }
        }
    }

    public void add(int position, int value) {
        if (root != null) {
            int currentPosition = 0;
            Node prevNode = null;
            Node node = root;
            while (node.getNext() != null) {
                if (currentPosition == position) {
                    break;
                }
                prevNode = node;
                node = node.getNext();
                currentPosition++;
            }
            if (currentPosition == position) {
                Node newNode = new Node();
                newNode.setElement(value);
                if (prevNode != null) {
                    newNode.setNext(prevNode.getNext());
                    prevNode.setNext(newNode);
                } else {
                    newNode.setNext(node);
                    root = newNode;
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
            if (node.getNext() != null) {
                System.out.println("\tNext value - " + node.getNext().getElement());
            } else {
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
}
