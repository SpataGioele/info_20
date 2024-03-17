public class LibreriaOnline {
    // attributi
    private String nome;
    private Lista libri = new Lista();

    // costruttori
    public LibreriaOnline(String nome) {
        this.nome = nome;
        libri = new Lista();
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista getLibri() {
        Lista ans = new Lista();

        for (Nodo tmp = libri.getHead(); tmp != null; tmp = tmp.getNext()) 
            ans.addLibro(tmp.getInfo().clone());

        return ans;
    }

    public void setLibri(Lista libri) {
        this.libri = libri;
    }

    // metodi
    public void showInfo() {
        libri.showInfo();
    }

    public boolean addLibro(Libro l) {
        return libri.addLibro(l);
    }

    public double findPrezzoByIsbn(String isbn) {
        if (libri.isEmpty())
            return -1.0;

        for (Nodo tmp = libri.getHead(); tmp != null; tmp = tmp.getNext()) 
            if (tmp.getInfo().getIsbn().equals(isbn))
                return tmp.getInfo().getPrezzoDiVendita();

        return -1.0;
    }

    public String findTitoloByIsbn(String isbn) {
        if (libri.isEmpty())
            return null;

        for (Nodo tmp = libri.getHead(); tmp != null; tmp = tmp.getNext()) 
            if (tmp.getInfo().getIsbn().equals(isbn))
                return tmp.getInfo().getTitolo();

        return null;
    }

    public Autore findAutoreByIsbn(String isbn) {
        if (libri.isEmpty())
            return null;

        for (Nodo tmp = libri.getHead(); tmp != null; tmp = tmp.getNext()) 
            if (tmp.getInfo().getIsbn().equals(isbn))
                return tmp.getInfo().getAutore().clone();

        return null;
    }

    public Libro findLibroHighestPrezzo() {
        Libro ans = libri.getHead().getInfo();

        for (Nodo tmp = libri.getHead(); tmp != null; tmp = tmp.getNext()) 
            if (ans.getPrezzoDiVendita() < tmp.getInfo().getPrezzoDiVendita())
                ans = tmp.getInfo();

        return ans.clone();
    }

    public Lista libriSortedByTitolo(boolean crescente) {
        Lista ans = new Lista();
        Lista temp = libri.deepCopy();
        
        while (!temp.isEmpty()) {
            Nodo nodoMin = temp.getHead();
            Nodo prevMin = null;
            Nodo curr = temp.getHead();
            for (Nodo tmp = temp.getHead(); tmp.getNext() != null; tmp = tmp.getNext()) {
                if (crescente) {
                    if (tmp.getNext().getInfo().getTitolo().compareTo(nodoMin.getInfo().getTitolo()) < 0) {
                        nodoMin = tmp.getNext();
                        prevMin = tmp;
                    }
                } else {
                    if (tmp.getNext().getInfo().getTitolo().compareTo(nodoMin.getInfo().getTitolo()) > 0) {
                        nodoMin = tmp.getNext();
                        prevMin = tmp;
                    }
                }
            }
            ans.addLibro(nodoMin.getInfo().clone());
            if (prevMin == null) {
                temp.setHead(nodoMin.getNext());
            } else {
                prevMin.setNext(nodoMin.getNext());
            }
        }
        
        return ans;
    }
}
