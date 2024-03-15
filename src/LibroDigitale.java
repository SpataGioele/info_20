public class LibroDigitale extends Libro {
    // attributi
    private double dimensione;
    private String estensione;

    // costruttori
    public LibroDigitale(String titolo, String isbn, int anno, String editore, double prezzoDiVendita, String cf, String nome,
     String cognome, double dimensione, String estensione) {
        super(titolo, isbn, anno, editore, prezzoDiVendita, cf, nome, cognome);
        this.dimensione = dimensione;
        this.estensione = estensione;
    }

    // getters and setters
    public double getDimensione() {
        return dimensione;
    }

    public void setDimensione(double dimensione) {
        this.dimensione = dimensione;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    // metodi
    @Override
    public String toString() {
        return super.toString() + ", dimensione: " + getDimensione() + ", estensione: " + getEstensione();
    }
}
