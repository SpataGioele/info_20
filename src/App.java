import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // apro scanner
        Scanner input = new Scanner(System.in);

        // creo libreria
        LibreriaOnline libreria = new LibreriaOnline("Feltrinelli");

        // working variable
        String isbn = null;
        String titolo = null;
        double prezzo = -1;

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
                case 3:
                    System.out.println("\nInserisci l´ISBN del libro");
                    isbn = input.nextLine();

                    prezzo = libreria.findPrezzoByIsbn(isbn);

                    if (prezzo != -1)
                        System.out.println("Il prezzo del libro è: " + prezzo);
                    else
                        System.out.println("\nISBN invalido");
                    break;
                case 4:
                    System.out.println("\nInserisci l´ISBN del libro");
                    isbn = input.nextLine();

                    titolo = libreria.findTitoloByIsbn(isbn);

                    if (titolo != null)
                        System.out.println("Il titolo del libro è: " + titolo);
                    else
                        System.out.println("\nISBN invalido");
                    break;
                case 5:
                    Libro l = libreria.findLibroHighestPrezzo();

                    if (l != null)
                        System.out.println(l.toString());
                    else
                        System.out.println("\nISBN invalido");
                    break;
                case 6:
                    System.out.println("Vuoi ordinare in modo crescente? [Y/n]");
                    boolean crescente = false;

                    if (input.nextLine().toLowerCase().equals("y"))
                        crescente = true;

                    Lista lista = libreria.libriSortedByTitolo(crescente);
                    lista.showInfo();
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
        System.out.println("3) Trova prezzo di un libro tramite isbn");   
        System.out.println("4) Trova titolo di un libro tramite isbn");   
        System.out.println("5) Trova il libro col prezzo più alto");   
        System.out.println("0) Esci");
    }

    public static Libro getLibroInputs(Scanner input) {
        boolean loop = false;
        boolean cartaceo = false;
        System.out.println("\nIl libro è cartaceo? [Y/n]");

        if (input.nextLine().toLowerCase().equals("y"))
            cartaceo = true;
        
        System.out.println("Inserisci l'isbn: ");
        String isbn = input.nextLine();
        System.out.println("Inserisci il titolo: ");
        String titolo = input.nextLine();

        int anno = -1;
        do {
            loop = false;
            try {
                System.out.println("Inserisci l'anno: ");
                anno = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("\nDato errato. Riprova.");
                loop = true;
            }
        } while (loop);
        
        System.out.println("Inserisci la casa editrice: ");
        String editore = input.nextLine();
        System.out.println("Inserisci il codice fiscale dell'autore: ");
        String cf = input.nextLine();
        System.out.println("Inserisci il nome dell'autore: ");
        String nome = input.nextLine();
        System.out.println("Inserisci il cognome dell'autore: ");
        String cognome = input.nextLine();

        double prezzoDiVendita = 0.0;
        do {
            loop = false;
            try {
                System.out.println("Inserisci il prezzo di vendita: ");
                prezzoDiVendita =  Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("\nDato errato. Riprova.");
                loop = true;
            }
        } while (loop);

        if (cartaceo) {
            double peso = 0.0;
            do {
                loop = false;
                try {
                    System.out.println("Inserisci il peso del file: ");
                    peso = Double.parseDouble(input.nextLine());
                } catch (Exception e) {
                    System.out.println("\nDato errato. Riprova.");
                    loop = true;
                }
            } while (loop);
            

            boolean copertinaRigida = false;
            System.out.println("Il libro ha una copertina rigida? [Y/n]");
            if (input.nextLine().toLowerCase().equals("y"))
                copertinaRigida = true;

            return new LibroCartaceo(titolo, isbn, anno, editore, prezzoDiVendita, peso, copertinaRigida, 1, cf, nome, cognome);
        } 

        double dimensione = 0.0;
        do {
            loop = false;
            try {
                System.out.println("Inserisci la dimensione del file: ");
                dimensione =  Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                System.out.println("\nDato errato. Riprova.");
                loop = true;
            }
        } while (loop);
        
        System.out.println("Inserisci l'estensione del file: ");
        String estensione = input.nextLine();
        return new LibroDigitale(titolo, isbn, anno, editore, prezzoDiVendita, cf, nome, cognome, dimensione, estensione);
    }
}
