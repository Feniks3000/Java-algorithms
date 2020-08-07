package lesson3;

public interface Iterator {
    boolean hasNext();

    boolean hasPrevious();

    Node next();

    Node previous();
}
