public class LibroCartaceo extends Libro {
    // attributi
    private Double peso;
    private boolean copertinaRigida;
    private int qtaMagazzino;

    // costruttori
    public LibroCartaceo(String titolo, String isbn, int anno, String editore, double prezzoDiVendita, Double peso,
    boolean copertinaRigida, int qtaMagazzino) {
        super(titolo, isbn, anno, editore, prezzoDiVendita);
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
    
}
