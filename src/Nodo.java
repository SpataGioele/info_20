public class Nodo {
    // attributi
    private Libro info;
    private Nodo next;

    // costruttori
    public Nodo(Libro info) {
        this.info = info;
        next = null;
    }

    // getters and setters
    public Libro getInfo() {
        return info;
    }

    public void setInfo(Libro info) {
        this.info = info;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    // metodi
    @Override
    public String toString() {
        return getInfo().toString();
    }
}
