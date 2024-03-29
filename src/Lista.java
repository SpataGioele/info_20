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

    public boolean isPresente(Libro l) {
        if (isEmpty()) 
            return false;

        for (Nodo tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getInfo().getIsbn().equals(l.getIsbn())) {
                if (tmp.getInfo() instanceof LibroCartaceo && l instanceof LibroCartaceo) 
                    ((LibroCartaceo) tmp.getInfo()).setQtaMagazzino(((LibroCartaceo) tmp.getInfo()).getQtaMagazzino() + 1);
     
                return true;
            }
        }           

        return false;
    }

    public Nodo findLast() {
        Nodo tmp;
        for (tmp = head; tmp.getNext() != null; tmp = tmp.getNext());
        return tmp;        
    }

    public Nodo findPos(Libro l) {
        Nodo tmp = head;
        String title = l.getTitolo();
    
        if (tmp == null || title.compareTo(tmp.getInfo().getTitolo()) < 0) 
            return null;
    
        while (tmp.getNext() != null && title.compareTo(tmp.getNext().getInfo().getTitolo()) > 0) 
            tmp = tmp.getNext();
    
        return tmp;
    }

    public boolean addLibro(Libro l) {
        if (isPresente(l)) return false;
    
        Nodo tmp = new Nodo(l);
        Nodo pos = findPos(l);
    
        if (pos == null) {
            tmp.setNext(head);
            head = tmp;
        } else {
            tmp.setNext(pos.getNext());
            pos.setNext(tmp);
        }
    
        return true;
    }

    public Lista deepCopy() {
        Lista nuovaLista = new Lista();
        
        if (head == null) 
            return nuovaLista; 
        
        nuovaLista.head = new Nodo(head.getInfo());
        Nodo nuovoNodo = nuovaLista.head;
        Nodo nodoOriginale = head.getNext();
        
        while (nodoOriginale != null) {
            nuovoNodo.setNext(new Nodo(nodoOriginale.getInfo()));
            nuovoNodo = nuovoNodo.getNext();
            nodoOriginale = nodoOriginale.getNext();
        }
        
        return nuovaLista;
    }
}
