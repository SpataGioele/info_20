public class LibroCartaceo extends Libro {
    // attributi
    private Double peso;
    private boolean copertinaRigida;
    private int qtaMagazzino;

    // costruttori
    public LibroCartaceo(String titolo, String isbn, int anno, String editore, double prezzoDiVendita, Double peso,
    boolean copertinaRigida, int qtaMagazzino, String cf, String nome, String cognome) {
        super(titolo, isbn, anno, editore, prezzoDiVendita, cf, nome, cognome);
        this.peso = peso;
        this.copertinaRigida = copertinaRigida;
        this.qtaMagazzino = qtaMagazzino;
    }
    
    // getters and setters
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isCopertinaRigida() {
        return copertinaRigida;
    }

    public void setCopertinaRigida(boolean copertinaRigida) {
        this.copertinaRigida = copertinaRigida;
    }

    public int getQtaMagazzino() {
        return qtaMagazzino;
    }

    public void setQtaMagazzino(int qtaMagazzino) {
        this.qtaMagazzino = qtaMagazzino;
    }

    // metodi
    @Override
    public String toString() {
        return super.toString() + ", peso: " + getPeso() + ", quota in magazzino: " + getQtaMagazzino();
    }
}
