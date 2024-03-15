public class Libro {
    // attributi
    private String titolo;
    private String isbn;
    private int anno;
    private String editore;
    private Autore autore; 
    private double prezzoDiVendita;
    
    // costruttori
    public Libro(String titolo, String isbn, int anno, String editore, double prezzoDiVendita) {
        this.titolo = titolo;
        this.isbn = isbn;
        this.anno = anno;
        this.editore = editore;
        this.prezzoDiVendita = prezzoDiVendita;
        autore = new Autore(titolo, isbn, editore);
    }

    // getters and setters
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public double getPrezzoDiVendita() {
        return prezzoDiVendita;
    }

    public void setPrezzoDiVendita(double prezzoDiVendita) {
        this.prezzoDiVendita = prezzoDiVendita;
    }

    // metodi
    @Override
    public String toString() {
        return "Libro [titolo=" + titolo + ", isbn=" + isbn + ", anno=" + anno + ", editore=" + editore + ", autore="
                + autore + ", prezzoDiVendita=" + prezzoDiVendita + "]";
    }
}