import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // apro scanner
        Scanner input = new Scanner(System.in);

        // creo libreria
        Lista libreria = new Lista();

        int scelta = -1;
        do {
            printMenu();
            scelta = Integer.parseInt(input.nextLine());

            switch (scelta) {
                case 0:
                    System.out.println("\nArrivederci!");
                    scelta = 0;
                    break;
                case 1:
                    System.out.println("\n- - LIBRERIA - -");
                    libreria.showInfo();
                    break;
                case 2:
                    libreria.addLibro(getLibroInputs(input));
                    break;
                default:
                    System.out.println("\nOpzione non valida. Riprova.");
                    break;
            }
        } while (scelta != 0);

        // chiudo scanner
        input.close();
    }

    public static void printMenu() {
        System.out.println("\n- - MENU - -");
        System.out.println("1) Mostra libreria"); 
        System.out.println("2) Inserisci libro");   // ordinata
        System.out.println("0) Esci");
    }

    public static Libro getLibroInputs(Scanner input) {
        boolean cartaceo = false;
        System.out.println("\nIl libro è cartaceo? [Y/n]");

        if (input.nextLine().toLowerCase().equals("y"))
            cartaceo = true;

        System.out.println("Inserisci l'isbn: ");
        String isbn = input.nextLine();
        System.out.println("Inserisci il titolo: ");
        String titolo = input.nextLine();
        System.out.println("Inserisci l'anno: ");
        int anno = Integer.parseInt(input.nextLine());
        System.out.println("Inserisci la casa editrice: ");
        String editore = input.nextLine();
        System.out.println("Inserisci il codice fiscale dell'autore: ");
        String cf = input.nextLine();
        System.out.println("Inserisci il nome dell'autore: ");
        String nome = input.nextLine();
        System.out.println("Inserisci il cognome dell'autore: ");
        String cognome = input.nextLine();
        System.out.println("Inserisci il prezzo di vendita: ");
        double prezzoDiVendita =  Double.parseDouble(input.nextLine());

        if (cartaceo) {
            System.out.println("Inserisci il peso del file: ");
            double peso = Double.parseDouble(input.nextLine());

            boolean copertinaRigida = false;
            System.out.println("Il libro ha una copertina rigida? [Y/n]");
            if (input.nextLine().toLowerCase().equals("y"))
                copertinaRigida = true;

            return new LibroCartaceo(titolo, isbn, anno, editore, prezzoDiVendita, peso, copertinaRigida, 1, cf, nome, cognome);
        } 

        System.out.println("Inserisci la dimensione del file: ");
        double dimensione =  Double.parseDouble(input.nextLine());
        System.out.println("Inserisci l'estensione del file: ");
        String estensione = input.nextLine();
        return new LibroDigitale(titolo, isbn, anno, editore, prezzoDiVendita, cf, nome, cognome, dimensione, estensione);
    }
}
