public class Lista {
    // attributi
    private Nodo head;

    public Lista() {
        head = null;
    }

    // getters and setters
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    // metodi
    public void showInfo() {
        for (Nodo tmp = head; tmp != null; tmp = tmp.getNext())
            System.out.println(tmp.getInfo().toString());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isPresente(String isbn) {
        if (isEmpty()) 
            return false;

        for (Nodo tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getInfo().getIsbn().equals(isbn)) {
                if (tmp.getInfo() instanceof LibroCartaceo) 
                    ((LibroCartaceo) tmp.getInfo()).setQtaMagazzino(((LibroCartaceo) tmp.getInfo()).getQtaMagazzino() + 1);
     
                return true;
            }
        }           

        return false;
    }

    public Nodo findPos(String titolo) {
        for (Nodo tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) 
            if (tmp.getNext().getInfo().getTitolo().compareTo(titolo) > 0) 
                return tmp;
            
        return null;
    }

    public boolean addLibro(Libro l) {
        if (isPresente(l.getIsbn()))
            return false;

        Nodo tmp = new Nodo(l);
        if (isEmpty()) {
            head = tmp;
        } else {
            tmp.setNext(findPos(l.getTitolo()).getNext());
            findPos(l.getTitolo()).setNext(tmp);
        }
        
        return true;
    }
}
